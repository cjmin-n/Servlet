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

        // DB 접속 설정 정보 파일의 경로가 비어 있는 경우에 초기화 해준다.
        // 최초 요청 시 DB 접속 경로와 매퍼 파일 경로를 설정해준다.
        if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null){
            String root = servletRequest.getServletContext().getRealPath("/"); // 현재 servlet의 루트 디렉토리 경로
            // ex) c:path\to\wepapp : 서버가 저장되어있는 실물 경로

            String connectionInfoPath = servletRequest.getServletContext().getInitParameter("connection-info");
            System.out.println("DB 접속 경로 설정 완료!");
            ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
        }

        if(ConfigLocation.MAPPER_LOCATION == null){
            String root = servletRequest.getServletContext().getRealPath("/"); // 현재 servlet의 루트 디렉토리 경로
            String mapperLocation = servletRequest.getServletContext().getInitParameter("mapper-location");

            System.out.println("매퍼 설정 완료");
            ConfigLocation.MAPPER_LOCATION = root + "/" + mapperLocation;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }


    @Override
    public void destroy() {

    }


}
