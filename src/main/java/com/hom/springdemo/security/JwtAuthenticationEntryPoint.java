package com.hom.springdemo.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring security其他异常处理类,比如请求路径不存在等，
 * 如果不配置此类，则Spring security默认会跳转到登录页面
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        System.out.println("JwtAuthenticationEntryPoint:" + authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "没有凭证");
    }
}