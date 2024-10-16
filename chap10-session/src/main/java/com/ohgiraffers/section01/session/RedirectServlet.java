package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 앞서 작성한 서블릿과 동일한 세션 아이디를 반환한다.
        HttpSession session = req.getSession();
        System.out.println("redirect 페이지 session id : " + session.getId());

        // 세션에 담긴 모든 Attribute 키 목록을 반환받을 수 있다.
        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        // 동일한 아이디를 가진 세션에서는 getAttribute 로 setAttribute 한 값을 꺼낼 수 있다.
        String firstName = (String)session.getAttribute("firstName");
        String lastName = (String)session.getAttribute("lastName");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out  = resp.getWriter();
        out.println("<h3> Your first name is " + firstName + " and last name is " + lastName + "</h3>");
        out.flush();
        out.close();
    }
}
