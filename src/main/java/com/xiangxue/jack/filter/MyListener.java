package com.xiangxue.jack.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("contextDestroyed"); }
    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("contextInitialized"); }
}
