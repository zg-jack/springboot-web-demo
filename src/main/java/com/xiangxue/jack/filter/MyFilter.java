package com.xiangxue.jack.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*",filterName = "myFilter")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("--------MyFilter----------");
        chain.doFilter(request,response);
    }
}
