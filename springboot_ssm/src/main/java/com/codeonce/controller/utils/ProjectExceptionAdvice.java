package com.codeonce.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为SpringMVC的异常处理器
// @ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex) {
        // 记录日志
        // 打印异常
        ex.printStackTrace();
        return new R("服务器故障，请稍后再试!");
    }

}
