package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    // 리다이렉트 받는 쪽에서는 get 방식으로 받아야한다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName); // null
        System.out.println("lastName = " + lastName); // null

        Cookie[] cookies = req.getCookies();
        // request 에서 쿠키 목록을 쿠키 배열로 꺼내온다.
        // getName 과 getValue 를 이용해 쿠키에 담긴 값을 사용한다.

        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());

            if("firstName".equals(cookies[i].getName())) {
                firstName = cookies[i].getValue();
            } else if("lastName".equals(cookies[i].getName())) {
                lastName = cookies[i].getValue();
            }
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<h3> your first name is " + firstName + " and last name is " + lastName + "</h3>");
        out.flush();
        out.close();
    }
}
