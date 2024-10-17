package com.ohgiraffers.mvc.common.jdbc;

import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// jdbc 연결을 관리하는 클래스
public class JDBCTemplate {

    // DB 연결을 생성하는 정적 메소드
    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        try {
            prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);

            con.setAutoCommit(false); // 실패했을 경우 롤백하려고 오토커밋 끔

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }



    public static void close(Connection con) {

        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {

        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {

        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // 커밋
    public static void commit(Connection con){

        try {
            if(con != null && !con.isClosed()){
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 롤백
    public static void rollback(Connection con){

        try {
            if(con != null && !con.isClosed()){
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
