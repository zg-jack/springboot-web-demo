package com.xiangxue.jack.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

public class JerseyResourceConfig extends ResourceConfig {

    public JerseyResourceConfig() {

        register(RequestContextFilter.class);

        // 加载资源文件,这里直接扫描com.xiangxue.jack.jersey下的所有api  JAX-RS
        packages("com.xiangxue.jack.jersey");
    }
}
