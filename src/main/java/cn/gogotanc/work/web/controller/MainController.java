package cn.gogotanc.work.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tanc
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "你好，世界");
        return "index";
    }
}
