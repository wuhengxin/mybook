package com.crm.web.interceptor;


import com.crm.context.EmployeeContext;
import com.crm.context.UserContext;
import com.crm.web.controller.BorrowBookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类描述信息 登入拦截器
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (UserContext.getCurrentUser() == null && EmployeeContext.getCurrentEmployee() == null) {
            response.sendRedirect("login.jsp");
            Logger logger= LoggerFactory.getLogger(CheckLoginInterceptor.class);
            logger.debug("CheckLoginInterceptor.preHandle" + "----------------未登入------拦截请求--------------->");
            return false;
        }
        return true;
    }
}
