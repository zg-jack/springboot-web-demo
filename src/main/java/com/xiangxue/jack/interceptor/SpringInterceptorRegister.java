package com.xiangxue.jack.interceptor;

import com.xiangxue.jack.servlet.JackServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
 *  往期视频加小露老师QQ：1533922121
 *  Jack老师QQ： 2943489129
 *  时间   ：     2017年12月26日 下午9:21:30 
 *  作者   ：   烛光学院【Jack老师】
 *  
 *  这个类就是类似于xml里面的拦截器定义
 */

@Configuration
public class SpringInterceptorRegister extends WebMvcConfigurerAdapter {
    
/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JackInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }*/

    @Bean
    public ServletRegistrationBean jackServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new JackServlet(),"/jack/*");
        return servletRegistrationBean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addResourceHandler("/img1/**")
                .addResourceLocations("classpath:/img1/");
        super.addResourceHandlers(registry);
    }

  /*  @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.jsp("/jsp/", ".jsp");
    }*/
}
