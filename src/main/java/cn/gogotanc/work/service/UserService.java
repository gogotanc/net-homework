package cn.gogotanc.work.service;

/**
 * 用户服务
 *
 * @author tanc
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return see Constant
     */
    int login(String username, String password);
}
