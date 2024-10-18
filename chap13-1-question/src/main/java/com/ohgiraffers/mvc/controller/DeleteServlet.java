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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("삭제할거임");

        int id = Integer.parseInt(req.getParameter("id"));

        BoardService boardService = new BoardService();
        int result = boardService.deleteItem(id);

        // 번호 순서 맞춰주기
        List<BoardDTO> boardList = boardService.selectAll();
        List<Integer> resultList = new ArrayList<>();
        for(BoardDTO boardDTO : boardList){
            int id2 = boardDTO.getId();

            if(id2 > id){
                System.out.println(id2);
                resultList.add(boardService.updateId(id2));
            }

        }

        System.out.println(resultList);
        for(Integer i : resultList){
            if(i > 0){
                System.out.println("아이디 변경 성공");
            }else {
                System.out.println("아이디 변경 실패 ㅜ");
            }
        }


        String path = "";
        if(result > 0) {
            System.out.println("삭제 성공!");
            
            path = "selectAll";
            
            resp.sendRedirect(path);
        } else {
            System.out.println("삭제 실패");

            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "삭제를 실패했습니다!");
            req.getRequestDispatcher(path).forward(req, resp);
        }
    }
}
