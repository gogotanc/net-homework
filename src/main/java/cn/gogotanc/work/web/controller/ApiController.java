package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.entity.CartItem;
import cn.gogotanc.work.service.CartService;
import cn.gogotanc.work.service.OrderService;
import cn.gogotanc.work.service.UserService;
import cn.gogotanc.work.utils.Constant;
import cn.gogotanc.work.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
}
