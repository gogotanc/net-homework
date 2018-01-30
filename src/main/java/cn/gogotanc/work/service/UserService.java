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
     * @return :
     * -1: 用户名密码错误
     * 0: 卖家
     * 1: 买家
     */
    int login(String username, String password);
}
