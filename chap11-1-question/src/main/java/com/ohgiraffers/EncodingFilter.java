package com.ohgiraffers;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter("/*")
public class EncodingFilter implements Filter {

    String encodingType = "text/html charset=utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType(encodingType);

        filterChain.doFilter(servletRequest, response);

    }

    @Override
    public void destroy() {


    }
}
