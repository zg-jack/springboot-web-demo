package com.xiangxue.jack.start;

import com.xiangxue.jack.druidConfig.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.xiangxue.jack"})
@MapperScan("com.xiangxue.jack.dao")
@ServletComponentScan(basePackages = {"com.xiangxue.jack"})
@EnableConfigurationProperties(DruidConfig.class)
public class SpringbootTest extends SpringBootServletInitializer {

    /*
    * 1、要完成Spring容器的启动
    * 2、把项目部署到tomcat
    * */
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootTest.class,
                args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootTest.class);
    }
}
