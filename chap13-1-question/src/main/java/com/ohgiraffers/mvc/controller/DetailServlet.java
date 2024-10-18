package com.ohgiraffers.mvc.controller;

import com.ohgiraffers.mvc.model.dto.BoardDTO;
import com.ohgiraffers.mvc.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("detail!!!");

        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id = " + id);

        BoardService boardService = new BoardService();

        BoardDTO board = boardService.selectContents(id);

        PrintWriter out = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder();

        if(board != null){
            // board 찾아온게 있으면
            System.out.println("null 아니지 !");

            stringBuilder.append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<p>제목 : ")
                    .append(board.getSubject())
                    .append("</p>\n")
                    .append("<p>내용 : ")
                    .append(board.getContent())
                    .append("</p>\n")
                    .append("<a href='selectAll'>돌아가기</a>\n")
                    .append("</body>\n")
                    .append("</html>");
            out.print(stringBuilder);

        } else {
            // board 찾아온거 있으면
            String path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "상세페이지 에러입니다!");
            req.getRequestDispatcher(path).forward(req, resp);
        }

        out.flush();
        out.close();
    }
}
