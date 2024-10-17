package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        long currentTime = System.currentTimeMillis();
        // currentTimeMillis() 함수는 1970년 1월 1일 0시를 기준으로 현재까지 경과한 시간을 1000분의 1초(밀리초)로 반환한다.
        out.print("<h1>" + currentTime + "</h1>");
        out.close();

        Collection<String> responseHeaders = resp.getHeaderNames();
        Iterator<String> iter = responseHeaders.iterator();

        while(iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + " : " + resp.getHeader(headerName));
            /*
            Content-Type : text/html;charset=UTF-8
            Content-Length : 22
            Date : Thu, 17 Oct 2024 08:41:39 GMT
            Keep-Alive : timeout=20
            Connection : keep-alive
            * */
        }
    }
}
