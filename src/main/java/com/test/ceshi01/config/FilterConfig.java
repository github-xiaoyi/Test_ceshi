package com.test.ceshi01.config;

import com.test.ceshi01.filter.HeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Filter过滤器配置实现,等价于xml中配置的字符过滤器
 */
@Configuration
public class FilterConfig {
    /**
     * <bean id="heFilterRegistrationBean" class="org.springframework.boot.web.servlet.FilterRegistrationBean">
     *
     * </bean>
     * @return
     */

    @Bean
    public FilterRegistrationBean heFilterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new HeFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    /**
     * <bean id="filterRegistrationBean" class="org.springframework.boot.web.servlet.FilterRegistrationBean">
     *
     * </bean>
     * @return
     */
    //spring编码拦截,需要将默认编码过滤器置为false,spring.http.encoding.enabled = false
    //建议通过springboot配置实现

  /*  @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registrationBean.setFilter(characterEncodingFilter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }*/

}
