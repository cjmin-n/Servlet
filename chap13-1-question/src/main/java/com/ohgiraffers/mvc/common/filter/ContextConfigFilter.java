package com.ohgiraffers.mvc.common.filter;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
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

        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null){
            String root = servletRequest.getServletContext().getRealPath("/");
            String connectionInfoPath = servletRequest.getServletContext().getInitParameter("connection-info");

            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
        }

        if(ConfigLocation.MAPPER_LOCATION == null) {
            String root = servletRequest.getServletContext().getRealPath("/");
            String mapperLocation = servletRequest.getServletContext().getInitParameter("mapper-location");
            ConfigLocation.MAPPER_LOCATION = root + "/" + mapperLocation;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }


}
