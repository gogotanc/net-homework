package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.service.CartService;
import cn.gogotanc.work.service.GoodsService;
import cn.gogotanc.work.service.OrderService;
import cn.gogotanc.work.service.UserService;
import cn.gogotanc.work.utils.Constant;
import cn.gogotanc.work.utils.Encoder;
import cn.gogotanc.work.utils.JsonResult;
import cn.gogotanc.work.web.vo.GoodsForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @author tanc
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     HttpServletRequest request) {
        JsonResult result = new JsonResult();

        logger.debug("login, username: {}, password: {}", username, password);

        int res = userService.login(request, username, password);

        logger.debug("login result code: {}", res);

        if (Constant.RESULT_CODE_ERROR == res) {
            result.setStatusFail("登录失败");
        } else {
            result.setStatusOK();
        }

        return result.toMap();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request) {

        JsonResult result = new JsonResult();
        userService.logout(request);
        return result.toMap();
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> cart(@RequestParam("goodsId") Integer goodsId,
                                    @RequestParam("count") Integer count) {
        CartItem item = new CartItem();
        item.setCount(count);
        item.setGoodsId(goodsId);
        cartService.addItem(item);
        JsonResult result = new JsonResult();
        return result.toMap();
    }

    @RequestMapping(value = "/updateCount", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> cartUpdateCount(@RequestParam("itemId") Integer itemId,
                                    @RequestParam("count") Integer count) {
        cartService.updateCount(itemId, count);
        JsonResult result = new JsonResult();
        return result.toMap();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> cartUpdateCount(@RequestParam("itemId") Integer itemId) {
        cartService.deleteItem(itemId);
        JsonResult result = new JsonResult();
        return result.toMap();
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> cartClear() {
        cartService.clear();
        JsonResult result = new JsonResult();
        return result.toMap();
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> order() {
        orderService.order();
        JsonResult result = new JsonResult();
        return result.toMap();
    }

    @RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteGoods(@RequestParam("id") Integer goodsId) {
        goodsService.delete(goodsId);
        JsonResult result = new JsonResult();
        return result.toMap();
    }

    /**
     * 添加商品
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addGoods(@Valid GoodsForm form, BindingResult bindingResult,
                                        @RequestParam("goodsPictureFile") MultipartFile file,
                                        @RequestParam("goodsPictureType") Integer pictureType,
                                        @RequestParam("goodsPictureLink") String link,
                                        HttpServletRequest request) {

        System.out.println(form);

        JsonResult result = new JsonResult();
        if (bindingResult.hasErrors()) {
            result.setStatusFail(bindingResult.getAllErrors().get(0).getDefaultMessage());
            return result.toMap();
        }

        if (null == pictureType) {
            result.setStatusFail("图片类型不能为空");
            return result.toMap();
        } else if (pictureType == 1 && null == link) {
            result.setStatusFail("图片链接不能为空");
            return result.toMap();
        } else if (pictureType == 2 && null == file) {
            result.setStatusFail("图片文件不能为空");
            return result.toMap();
        }

        Goods goods = createNewGoods(form, link);
        goods.setFlag(Constant.GOODS_FLAG_UNSOLD);

        // 如果是选择上传了图片文件
        if (pictureType.equals(Constant.PICTURE_TYPE_FILE)) {

            // /Users/tanc/project/neeet/src/main/webapp/
            String path = request.getServletContext().getRealPath("/") + "upload" + File.separator;

            File dir = new File(path);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    result.setStatusFail();
                    return result.toMap();
                }
            }
            // 写文件到服务器
            String fileOriginName = file.getOriginalFilename();
            String suffix = fileOriginName.substring(fileOriginName.lastIndexOf("."), fileOriginName.length());
            String fileName = Constant.UPLOAD_FILE_PREFIX + Encoder.getUUID() + suffix;
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            try {
                file.transferTo(serverFile);
            } catch (IOException e) {
                e.printStackTrace();
                result.setStatusFail();
                return result.toMap();
            }

            goods.setPicture(fileName);
        }

        // add goods to database
        goodsService.add(goods);

        result.setStatusOK(goods.getId() + "");
        return result.toMap();
    }

    /**
     * 由表单数据生成一个新的 Goods 对象
     */
    private Goods createNewGoods(GoodsForm form, String picture) {
        Goods goods = new Goods();
        goods.setModifyTime(new Date());
        goods.setRegisterTime(new Date());
        goods.setPrice(form.getGoodsPrice());
        goods.setSummary(form.getGoodsSummary());
        goods.setContent(form.getGoodsDetail());
        goods.setTitle(form.getGoodsName());
        goods.setPicture(picture);
        return goods;
    }

    /**
     * 修改商品
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyGoods(@Valid GoodsForm form, BindingResult bindingResult,
                                        @RequestParam("goodsPictureFile") MultipartFile file,
                                        @RequestParam("goodsId") Integer goodsId,
                                        @RequestParam("goodsPictureType") Integer pictureType,
                                        @RequestParam("goodsPictureLink") String link,
                                        HttpServletRequest request) {

        JsonResult result = new JsonResult();
        if (bindingResult.hasErrors()) {
            result.setStatusFail(bindingResult.getAllErrors().get(0).getDefaultMessage());
            return result.toMap();
        }

        if (null == pictureType) {
            result.setStatusFail("图片类型不能为空");
            return result.toMap();
        } else if (pictureType == 1 && null == link) {
            result.setStatusFail("图片链接不能为空");
            return result.toMap();
        } else if (pictureType == 2 && null == file) {
            result.setStatusFail("图片文件不能为空");
            return result.toMap();
        }

        Goods goods = goodsService.find(goodsId);
        goods.setTitle(form.getGoodsName());
        goods.setSummary(form.getGoodsSummary());
        goods.setContent(form.getGoodsDetail());
        goods.setPrice(form.getGoodsPrice());
        goods.setModifyTime(new Date());
        goods.setPicture(link);

        // 如果是选择上传了图片文件
        if (pictureType.equals(Constant.PICTURE_TYPE_FILE)) {

            // /Users/tanc/project/neeet/src/main/webapp/
            String path = request.getServletContext().getRealPath("/") + "upload" + File.separator;

            File dir = new File(path);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    result.setStatusFail();
                    return result.toMap();
                }
            }
            // 写文件到服务器
            String fileOriginName = file.getOriginalFilename();
            String suffix = fileOriginName.substring(fileOriginName.lastIndexOf("."), fileOriginName.length());
            String fileName = Constant.UPLOAD_FILE_PREFIX + Encoder.getUUID() + suffix;
            File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
            try {
                file.transferTo(serverFile);
            } catch (IOException e) {
                e.printStackTrace();
                result.setStatusFail();
                return result.toMap();
            }

            goods.setPicture(fileName);
        }

        // add goods to database
        goodsService.update(goods);

        result.setStatusOK(goods.getId() + "");
        return result.toMap();
    }
}
