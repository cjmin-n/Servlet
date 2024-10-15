package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("이 서블릿으로 redirect 성공");
        System.out.println(resp); // org.apache.catalina.connector.ResponseFacade@70daeadb

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<h1>이 서블릿으로 redirect 성공</h1>");
        out.flush();
        out.close();
        
        /*
        * redirect 하면 url 이 재작성되어 새로고침할 때 redirect 된 페이지에 대한 요청을 반복한다.
        * 즉, 이전 요청에 포함된 정보는 남아있지 않고, url 이 변경되는 것이 redirect 의 특징이다.
        * 첫 요청 시의 request 와 현재 redirect 된 페이지의 request 는 서로 다른 객체이므로
        * redirect 를 쓰면 이전 서블릿의 값을 공유해서 사용할 수 없다.
        * http 요청은 요청 시 잠시 connection 을 맺고 응답 시에도 잠시 connection 을 맺으며
        * 요청 단위 당 request 객체는 한 개만 생성된다.
        * */
    }

}
