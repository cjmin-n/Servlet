package com.ohgiraffers.section03.requestlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("username", "honggildong");
        req.setAttribute("age", 20);
        req.setAttribute("gender", "M");


        req.setAttribute("username", "hong");


        req.removeAttribute("gender");

    }
}
