package com.xtm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理登陆的拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin = request.getSession().getAttribute("admin");
        if (admin == null) {
            request.setAttribute("msg", "没有权限请先登录");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        } else
            return true;
    }
}
