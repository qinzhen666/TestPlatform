package com.springbootdemo.spbtdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author : QinZhen
 * @Date : 2020/11/18 8:41 下午
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private DemoInterceptor demoInterceptor;

    //这个方法是用来配置静态资源的，比如HTML，js, css等等
    //前后端分离的开发模式，后端没有静态资源，可以不用这个方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

    }


    //这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // addPathPatterns("/**") 表示拦截所有的请求
        // excludePathPatterns("/login", "/register") 表示除了登录与注册之外，因为登录注册不需要登录也可以访问
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
//                .excludePathPatterns("/hogwartsTestUser/login");

    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        super.configureMessageConverters(converters);
        converters.add(messageConverter());
    }

    @Bean
    public HttpMessageConverter<String> messageConverter(){
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
