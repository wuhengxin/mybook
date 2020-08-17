package com.crm.context;

import com.crm.domain.Employee;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @program: CRM
 * @description:EmployeeContext类用户获取当前session会话中信息，用来检验用户是否已经登录
 * @author: wuhx
 * @create: 2020-08-10 09:26
 **/
public class EmployeeContext {
    public static final String EMPLOYEE_IN_SESSION = "employee_in_session";

    private static HttpSession getSession() {

        return ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest().getSession();
    }

    // 设置员工登入的Session
    public static void setEmployeeInSession(Employee contextEmployee) {
        if (contextEmployee != null) {
            //保存session
            getSession().setAttribute(EMPLOYEE_IN_SESSION, contextEmployee);
        } else {
            //注销session
            getSession().invalidate();
        }
    }

    // 共享给外部调用登入session
    public static Employee getCurrentEmployee() {
        return (Employee) getSession().getAttribute(EMPLOYEE_IN_SESSION);
    }

}
