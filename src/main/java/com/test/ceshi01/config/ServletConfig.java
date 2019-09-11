package com.test.ceshi01.config;

import com.test.ceshi01.servlet.HeServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过配置实现注册servlet
 * spring没有配置文件，@Configuration标示为spring的一个配置文件
 */
@Configuration
public class ServletConfig {
    /**
     * @Bean实现spring配置中
     * <bean id="heServletRegistrationBean" class="org.springframework.boot.web.servlet.ServletRegistrationBean">
     *
     * </bean>
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean heServletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HeServlet(),"/servlet/heservlet");
        return registrationBean;
    }
}
