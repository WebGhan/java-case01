package com.gaohan.case01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// @WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override // 初始化方法，Web服务器启动并创建Filter时调用，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
        System.out.println("init");
    }

    @Override // 拦截到请求时调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DemoFilter 放行前，拦截请求");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("DemoFIlter 放行后，拦截响应");
    }

    @Override // 销毁方法，服务关闭时调用，只调用一次
    public void destroy() {
        // Filter.super.destroy();
        System.out.println("destroy");
    }
}
