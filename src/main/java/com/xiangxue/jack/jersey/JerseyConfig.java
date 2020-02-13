package com.xiangxue.jack.jersey;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {
    @Bean
    public ServletRegistrationBean jerseyServlet() {
        //手动注册servlet
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
        registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,JerseyResourceConfig.class.getName());
        return registrationBean;
    }
}
