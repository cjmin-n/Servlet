package com.ohgiraffers.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/newBoard")
public class newBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("게시글 작성하기 눌렀지롱");
        req.getRequestDispatcher("/WEB-INF/views/board/newBoard.jsp").forward(req, resp);
    }
}
