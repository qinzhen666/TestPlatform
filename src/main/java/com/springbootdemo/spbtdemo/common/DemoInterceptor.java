package com.springbootdemo.spbtdemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : QinZhen
 * @Date : 2020/11/18 8:55 上午
 */
@Component  //声明为spring的一个bean
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("====preHandler====");
        log.info("====request.getRequestURI()====" + request.getRequestURI());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("====postHandle====");
        log.info("====request.getRequestURI()====" + request.getRequestURI());
        response.setCharacterEncoding("utf-8");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("====afterCompletion====");
        log.info("====request.getRequestURI()====" + request.getRequestURI());
    }
}
