package com.crm.ex;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类描述信息 统一异常处理器
 *
 * @author wuhx
 * @ClassName ExceptionControllerAdvice
 * @date 2020/02/24 15:53
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String errorView(Exception ex) {

        return "出现异常了" + ex.getMessage();
    }
}
