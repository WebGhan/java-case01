package com.gaohan.case01.filter;

import com.alibaba.fastjson.JSONObject;
import com.gaohan.case01.pojo.Result;
import com.gaohan.case01.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
// @WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 1. 获取请求 url
        String url = request.getRequestURL().toString();
        log.info("请求的url: {}", url);

        // 2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if (url.contains("login")) {
            log.info("登录操作，放行...");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 获取请求头中的令牌（token）
        String jwt = request.getHeader("token");

        // 4. 判断token是否存在，如果不存在，返回登录错误。
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空");
            Result error = Result.error("NOT_LOGIN");
            // 转为JSON格式（阿里巴巴fastJSON工具包）
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin);
            return;
        }

        // 5. 校验token，如果失败，返回错误结果。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            Result error = Result.error("NOT_LOGIN");
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin);
            return;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
