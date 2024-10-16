package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 회원가입 시 입력한 값들 가져오기
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        
        // 세션에 저장하기
        HttpSession session = req.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("password", password);
        session.setAttribute("email", email);
        
        // 저장 후 로그인 페이지로 이동
        resp.sendRedirect("login.jsp");

    }
}
