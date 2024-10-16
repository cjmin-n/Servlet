package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // FilterConfig 는 filter에 대한 매개변수를 가져올 수 있다.
        // xml 내부에 init-param 에 작성한 내용

        encodingType = filterConfig.getInitParameter("encoding-type");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;
        hresponse.setContentType(encodingType);

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
