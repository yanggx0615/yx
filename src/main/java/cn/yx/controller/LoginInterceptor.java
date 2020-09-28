package cn.yx.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 杨国祥
 * 拦截没有被
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod method =(HandlerMethod) handler;
            return true;
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return true;
    }


}
