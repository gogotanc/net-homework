package cn.gogotanc.work.web.interceptor;

import cn.gogotanc.work.utils.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tanc
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String identity = (String) request.getSession().getAttribute(Constant.USER_SESSION_IDENTITY);

        if (null != identity) {
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}
