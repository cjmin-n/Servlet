package com.ohgiraffers.mvc.model.dao;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import com.ohgiraffers.mvc.model.dto.BoardDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class BoardDAO {

    Properties prop;

    public BoardDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "board-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public int selectId(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        int id = 0;

        String query = prop.getProperty("selectId");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                id = rset.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }

        return id;
    }

    public int insertItem(Connection con, BoardDTO board) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("insertItem");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, board.getId());
            pstmt.setString(2, board.getSubject());
            pstmt.setString(3, board.getContent());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }



    public List<BoardDTO> selectAll(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<BoardDTO> boardList = new ArrayList<BoardDTO>();

        String query = prop.getProperty("selectAll");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();
            BoardDTO board;

            while(rset.next()) {
                board = new BoardDTO();

                board.setId(rset.getInt(1));
                board.setSubject(rset.getString(2));
                board.setContent(rset.getString(3));
                boardList.add(board);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);

        }

        return boardList;
    }

    public BoardDTO selectContents(Connection con, int id) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        BoardDTO board = null;

        String query = prop.getProperty("selectContents");

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1, id);
            rset = pstmt.executeQuery();

            if(rset.next()) {
                board = new BoardDTO();
                board.setId(rset.getInt(1));
                board.setSubject(rset.getString(2));
                board.setContent(rset.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }

        return board;
    }

    public int updateContents(Connection con, BoardDTO board) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("updateContents");

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, board.getSubject());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int deleteItem(Connection con, int id) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("deleteItem");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int updateId(Connection con, int id2) {
        System.out.println("update?");
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("updateId");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id2-1);
            pstmt.setInt(2, id2);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}
