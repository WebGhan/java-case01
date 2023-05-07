package com.gaohan.case01.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.gaohan.case01.pojo.Result;
import com.gaohan.case01.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 目标资源方法运行前运行，返回true: 放行，返回false: 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 获取请求 url
        String url = request.getRequestURL().toString();
        log.info("请求的url: {}", url);

        // 2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if (url.contains("login")) {
            log.info("登录操作，放行...");
            return true;
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
            return false;
        }

        // 5. 校验token，如果失败，返回错误结果。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            Result error = Result.error("NOT_LOGIN");
            String noLogin = JSONObject.toJSONString(error);
            response.getWriter().write(noLogin);
            return false;
        }

        // 6. 放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override // 目标资源方法执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
    }

    @Override // 视图渲染完毕后执行，最后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion ...");
    }
}
