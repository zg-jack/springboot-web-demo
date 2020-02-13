package com.xiangxue.jack.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements CommandLineRunner {
    
    public void run(String... args) throws Exception {
        System.out.println("------------------StartUp.run-------------------");
    }
    
}
