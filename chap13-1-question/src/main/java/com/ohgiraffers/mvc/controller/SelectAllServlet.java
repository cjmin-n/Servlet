package com.ohgiraffers.mvc.controller;

import com.ohgiraffers.mvc.model.dto.BoardDTO;
import com.ohgiraffers.mvc.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("작성하기 버튼 눌렀지롱");

        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        // id 마지막번호 가져와서 +1 / DTO에 저장
        BoardService boardService = new BoardService();
        int id = boardService.selectId();
        if(id == 0){
            id += 1;
        }
        System.out.println("id = " + id);

        BoardDTO board = new BoardDTO();
        if(id != 0) board.setId(id);
        board.setSubject(subject);
        board.setContent(content);

        System.out.println("board = " + board);

        // board에 DTO 저장
        int result = boardService.insertItem(board);

        String path = "";
        if(result > 0){
            // DTO에 저장 성공했을 때
            System.out.println("DTO에 저장 성공 !");

            List<BoardDTO> boardList = boardService.selectAll();
            System.out.println("boardList = " + boardList);

            req.setAttribute("list", boardList);

            path = "/WEB-INF/views/board/selectAll.jsp";

        } else {
            // DTO 에 저장 성공 못했을 때
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 등록에 실패했습니다.");
        }
        req.getRequestDispatcher(path).forward(req, resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardService boardService = new BoardService();
        List<BoardDTO> boardList = boardService.selectAll();
        System.out.println("boardList = " + boardList);

        req.setAttribute("list", boardList);

        req.getRequestDispatcher("/WEB-INF/views/board/selectAll.jsp").forward(req, resp);
    }
}
