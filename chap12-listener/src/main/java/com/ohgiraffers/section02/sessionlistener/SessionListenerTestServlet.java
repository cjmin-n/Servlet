package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // jsp 쪽에서 session을 임의로 만듦(3개?)
        // index.jsp에 <%@ page session="false" %> 를 주고
        // getSession()에 파라미터로 true를 주면, session이 없으면 생성된다. // true 가 없어도 가능
        HttpSession session = req.getSession(true);
        System.out.println("발급받은 session id : " + session.getId());

        session.setAttribute("username", "honggildong");

        session.setAttribute("username", "hong");

        session.invalidate(); // 세션 만료
    }
}
