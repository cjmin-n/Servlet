package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        // HttpServlet 으로 받았기 때문에 사용하려면 ServletRequest req, servletResponse res 를 다운캐스팅해야한다.

        // httpRequest 의 getMethod() 는 어떠한 http method 요청이 들어온건지
        // 문자열로 반환한다.
        String httpMethod = httpRequest.getMethod();
        System.out.println("http method : " + httpMethod);

        // 구현이 되어있기 때문에 따로 해줄 필요 없음
        if(("GET").equals(httpMethod)){
            doGet(httpRequest, httpResponse);
        }else if(("POST").equals(httpMethod)){
            doPost(httpRequest, httpResponse);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }


}
