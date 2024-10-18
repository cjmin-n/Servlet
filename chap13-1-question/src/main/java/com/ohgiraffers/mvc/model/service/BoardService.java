package com.ohgiraffers.mvc.model.service;

import com.ohgiraffers.mvc.model.dao.BoardDAO;
import com.ohgiraffers.mvc.model.dto.BoardDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;

public class BoardService {

    BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }


    public int selectId() {

        Connection con = getConnection();

        int id = boardDAO.selectId(con);


        return id;
    }

    public int insertItem(BoardDTO board) {

        Connection con = getConnection();
        int result = boardDAO.insertItem(con, board);

        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public List<BoardDTO> selectAll() {

        Connection con = getConnection();
        List<BoardDTO> boardList = boardDAO.selectAll(con);

        close(con);

        return boardList;
    }

    public BoardDTO selectContents(int id) {

        Connection con = getConnection();
        BoardDTO board = boardDAO.selectContents(con, id);

        close(con);

        return board;
    }

    public int updateContents(BoardDTO board) {

        Connection con = getConnection();
        int result = boardDAO.updateContents(con, board);

        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int deleteItem(int id) {

        Connection con = getConnection();
        int result = boardDAO.deleteItem(con, id);

        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int updateId(int id2) {

        Connection con = getConnection();
        int result = boardDAO.updateId(con, id2);
        System.out.println("service" + result);

        if(result > 0){
            commit(con);
        }else {
            rollback(con);
        }

        close(con);

        return result;
    }
}
