package com.ohgiraffers.mvc.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // DB 접속 설정 정보 파일의 경로가 비어 있는 경우에 초기화 해준다.
        // 최초 요청 시 DB 접속 경로와 매퍼 파일 경로를 설정해준다.


    }


    @Override
    public void destroy() {

    }


}
