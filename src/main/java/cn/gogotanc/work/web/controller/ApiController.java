package cn.gogotanc.work.web.controller;

import cn.gogotanc.work.service.UserService;
import cn.gogotanc.work.utils.Constant;
import cn.gogotanc.work.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/login")
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

    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request) {

        JsonResult result = new JsonResult();
        userService.logout(request);
        return result.toMap();
    }
}
