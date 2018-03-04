package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.entity.FinanceItem;
import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.service.CartService;
import cn.gogotanc.work.service.GoodsService;
import cn.gogotanc.work.service.OrderService;
import cn.gogotanc.work.utils.Constant;
import cn.gogotanc.work.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author tanc
 */
@Controller
public class MainController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "tag", defaultValue = "1") Integer tag) {
        model.addAttribute("message", "hello");

        List<Goods> goodsList;

        if (null != tag && Constant.INDEX_TAG_UNSOLD == tag) {
            goodsList = goodsService.getUnsold();
        } else {
            goodsList = goodsService.getAll();
        }

        model.addAttribute("tag", tag);
        model.addAttribute("goodsList", goodsList);
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(@RequestParam("id") Integer goodsId, Model model) {
        Goods goods = goodsService.find(goodsId);
        if (goods.getFlag() == Constant.GOODS_FLAG_SOLD) {
            FinanceItem item = orderService.findItemByGoodsId(goods.getId());
            model.addAttribute("order", item);
        }
        model.addAttribute("goods", goods);
        return "detail";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        List<GoodsItem> list = cartService.getAllItem();
        int total = 0;
        for (GoodsItem item : list) {
            total += item.getPrice() * item.getCount();
        }
        double doubleTotal = Converter.price2Double(total);
        model.addAttribute("cart", list);
        model.addAttribute("total", doubleTotal);
        return "cart";
    }

    @RequestMapping("/finance")
    public String finance(Model model) {
        List<FinanceItem> list = orderService.getAllItem();
        int total = 0;
        for (FinanceItem item : list) {
            total += item.getPrice() * item.getCount();
        }
        double doubleTotal = Converter.price2Double(total);
        model.addAttribute("list", list);
        model.addAttribute("total", doubleTotal);
        return "finance";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/modify")
    public String modify(@RequestParam(value = "id", required = true) Integer goodsId,
                         Model model) {

        Goods goods = goodsService.find(goodsId);

        // 判断是否可以修改
        if (null == goods) {
            model.addAttribute("message", "商品不存在。");
            return "message";
        }

        model.addAttribute("goods", goods);
        return "modify";
    }
}
