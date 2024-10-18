package com.ohgiraffers.mvc.controller;

import com.ohgiraffers.mvc.model.dto.BoardDTO;
import com.ohgiraffers.mvc.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));


        BoardService boardService = new BoardService();

        BoardDTO board = boardService.selectContents(id);

        PrintWriter out = resp.getWriter();
        StringBuilder stringBuilder = new StringBuilder();

        if(board != null){
            // board 찾아온게 있으면
            System.out.println("null 아니지 !");

            HttpSession session = req.getSession();
            session.setAttribute("id", id);

            stringBuilder.append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<form action='edit' method='post'>\n")
                    .append("<div>\n")
                    .append("<label for=\"subject\">제목 : </label>\n")
                    .append("<input type='text' id='subject' name='subject' value='")
                    .append(board.getSubject())
                    .append("'/>\n")
                    .append("</div>\n")
                    .append("<div>\n")
                    .append("<label for=\"content\">내용 : </label>\n")
                    .append("<textarea id='content' name='content'>")
                    .append(board.getContent())
                    .append("</textarea>\n")
                    .append("</div>\n")
                    .append("<button type='submit'>수정하기</button>\n")
                    .append("</form>\n")
                    .append("<a href='selectAll'>돌아가기</a>\n")
                    .append("</body>\n")
                    .append("</html>");
            out.print(stringBuilder);

        } else {
            // board 찾아온거 있으면
            String path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "수정 페이지 에러입니다!");
            req.getRequestDispatcher(path).forward(req, resp);
        }

        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("edit post지룡");

        HttpSession session = req.getSession();

        // 수정할 값
        int id = (int) session.getAttribute("id");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");


        BoardDTO board = new BoardDTO();

        BoardService boardService = new BoardService();

        board.setId(id);
        board.setSubject(subject);
        board.setContent(content);

        System.out.println("board = " + board);

        int result = boardService.updateContents(board);

        String path = "";
        if(result > 0){
            // 수정 성공
            System.out.println("데이터 수정 성공 !");

            path = "selectAll";
            resp.sendRedirect(path);

        } else {
            // 수정 실패
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "수정에 실패했습니다!");
            req.getRequestDispatcher(path).forward(req, resp);
        }


    }
}
