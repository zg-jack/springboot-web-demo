package com.xiangxue.jack.aware;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = {"com.xiangxue"})
public class ComponentScanBean {

//    @Bean
//    public void com.jack.controller.xx() {
//        System.out.println("==");
//    }
}
