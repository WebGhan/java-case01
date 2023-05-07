package com.gaohan.case01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// @WebFilter(urlPatterns = "/login")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AbcFilter 放行前，拦截请求");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("AbcFilter 放行后，拦截响应");
    }
}
