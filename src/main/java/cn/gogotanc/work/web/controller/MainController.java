package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.entity.FinanceItem;
import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.entity.GoodsItem;
import cn.gogotanc.work.entity.Order;
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
            Order order = orderService.findByGoodsId(goods.getId());
            model.addAttribute("order", order);
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
        model.addAttribute("cart", list);
        return "cart";
    }

    @RequestMapping("/finance")
    public String finance(Model model) {
        List<FinanceItem> list = orderService.getAllItem();
        int total = 0;
        for (FinanceItem item : list) {
            total += item.getPrice();
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
}
