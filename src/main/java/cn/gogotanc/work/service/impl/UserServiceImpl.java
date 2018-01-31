package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.service.UserService;
import cn.gogotanc.work.utils.Constant;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tanc
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String BUYER = "buyer";
    private static final String SELLER = "seller";
    private static final String BUYER_PASS_MD5 = "37254660E226EA65CE6F1EFD54233424";
    private static final String SELLER_PASS_MD5 = "981C57A5CFB0F868E064904B8745766F";

    @Override
    public int login(HttpServletRequest request, String username, String password) {
        int resultCode = Constant.RESULT_CODE_ERROR;
        switch (username) {
            case BUYER:
                if (BUYER_PASS_MD5.equalsIgnoreCase(password)) {
                    resultCode = Constant.IDENTITY_BUYER;
                    request.getSession().setAttribute(Constant.USER_SESSION_IDENTITY, Constant.IDENTITY_BUYER);
                }
                break;
            case SELLER:
                if (SELLER_PASS_MD5.equalsIgnoreCase(password)) {
                    resultCode = Constant.IDENTITY_SELLER;
                    request.getSession().setAttribute(Constant.USER_SESSION_IDENTITY, Constant.IDENTITY_SELLER);
                }
                break;
            default:
        }
        return resultCode;
    }

    @Override
    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.USER_SESSION_IDENTITY);
    }
}
