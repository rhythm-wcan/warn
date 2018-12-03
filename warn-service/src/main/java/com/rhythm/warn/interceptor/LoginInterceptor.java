package com.rhythm.warn.interceptor;

import com.rhythm.warn.annotation.DisableLogin;
import com.rhythm.warn.errorcode.ErrorCode;
import com.rhythm.warn.exception.BusinessException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 登录拦截器
 *
 * @author majunjie
 * @date 2018/12/3 18:02
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            DisableLogin annotation = method.getAnnotation(DisableLogin.class);
            if (annotation==null) {
                //校验登录
                HttpSession session = request.getSession();
                String sessionId = session.getId();
                if (session.getAttribute(sessionId) == null) {
                    throw new BusinessException(ErrorCode.ILLEGAL_FAIL);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
