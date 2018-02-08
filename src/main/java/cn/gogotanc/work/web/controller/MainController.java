package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.entity.Goods;
import cn.gogotanc.work.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tanc
 */
@Controller
public class MainController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/")
    public String index(Model model) {
        Goods goods = goodsService.find(10000);
        model.addAttribute("message", "你好，世界");
        model.addAttribute("goods", goods);
        return "index";
    }
}
