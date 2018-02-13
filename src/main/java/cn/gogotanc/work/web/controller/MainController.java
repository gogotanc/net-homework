package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.service.GoodsService;
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

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "tag", defaultValue = "1") Integer tag) {
        model.addAttribute("message", "hello");

        List<Goods> goodsList;

        if (null != tag && 2 == tag) {
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
        model.addAttribute("goods", goods);
        return "detail";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/cart")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/finance")
    public String finance() {
        return "finance";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }
}
