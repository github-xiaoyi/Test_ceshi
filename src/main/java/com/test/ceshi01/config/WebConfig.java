package com.test.ceshi01.config;

import com.test.ceshi01.interceptor.ControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

/**
 * 自定义拦截器ControllerInterceptor的拦截器配置
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //拦截的路径
    String[] addPathPatterns ={
        "/hello/showgirl",
        "/girls"
    };

    //不拦截的路径
    String[] excludePathPatterns={
        "/hello/say/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ControllerInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}

/*
public class  WebConfig extends WebMvcConfigurationSupport{
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new 自定义拦截器类名).addPathPatterns().excludePathPatterns();
        super.addInterceptors(registry);
    }
}
*/



