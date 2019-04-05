package com.company.tem.config;

import com.company.tem.aop.SessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: yuandh
 * @Description: session配置
 * @Date: Created in 11:14 2019/4/3
 * @Modified By:
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    //注册session监听器;
    @Bean
    public ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SessionListener> slrBean = new ServletListenerRegistrationBean<SessionListener>();
        slrBean.setListener(new SessionListener());
        return slrBean;
    }


}
