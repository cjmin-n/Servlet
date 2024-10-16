package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 특정 요청을 받은 필터
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;

        // 암호화는 RequestWrapper 클래스에서 처리
        RequestWrapper wrapper = new RequestWrapper(hrequest);

        // 서블릿으로 보내줌
        filterChain.doFilter(wrapper, servletResponse); // wrapper가 HttpServletRequestWrapper의 후손이기 때문에 servletRequest 자리에 넣을 수 있음


    }

    @Override
    public void destroy() {

    }


}
