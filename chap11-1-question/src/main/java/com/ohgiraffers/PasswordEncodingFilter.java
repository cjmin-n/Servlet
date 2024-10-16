package com.ohgiraffers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/register") // 회원가입 시 세션에 저장할 때 암호화
public class PasswordEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        
        // 다운캐스팅
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        
        // HttpServletRequest(인터페이스)를 상속받은 HttpServletRequestWrapper(클래스)를 상속받은 클래스를 만들어 요청을 처리한다.
        RequestWrapper wrapper = new RequestWrapper(request);
        // servlet으로 전달
        filterChain.doFilter(wrapper, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
