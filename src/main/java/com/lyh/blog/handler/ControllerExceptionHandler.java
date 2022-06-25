package com.lyh.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 */


//拦截所有Controller控制器的异常
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //配置Exception级别的异常
    @ExceptionHandler(Exception.class)
    //返回错误页面
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){

        logger.error("Request URL : {},Exception : {}",request.getRequestURL());

        ModelAndView mv = new ModelAndView();
        //获取前端页面URL
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }

}
