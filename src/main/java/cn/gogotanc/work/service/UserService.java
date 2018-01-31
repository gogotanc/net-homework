package cn.gogotanc.work.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
 * @author tanc
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param request 用户请求
     * @param username 用户名
     * @param password 密码
     * @return see Constant
     */
    int login(HttpServletRequest request, String username, String password);

    /**
     * 用户注销
     */
    void logout(HttpServletRequest request);
}
