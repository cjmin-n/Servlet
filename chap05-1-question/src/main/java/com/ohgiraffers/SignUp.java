package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;


@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name");
        String tel = req.getParameter("tel");
        String password = req.getParameter("password");
        String passwordCheck = req.getParameter("passwordCheck");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();


        /*if(username != null && username.trim().length() >= 2) {
            if(Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z]*$", username)){
                if(tel != null && tel.length() == 11){
                    if(Pattern.matches("^[0-9]{11}$", tel)){
//                    if(Pattern.matches("^[0-9]*$", tel)){
                        if(password != null && password.length() >= 8){
                            if(password.equals(passwordCheck)){
                                out.print("<h1>환영 합니다 " + username + "님 </h1>");
                            }else {
                                out.print("<h1>입력 정보를 확인해주세요.</h1>");
                            }
                        }else {
                            out.print("<h1>비밀번호는 8자리 이상이어야 합니다.</h1>");
                        }    
                    }else {
                        out.print("<h1>전화번호는 숫자이어야 합니다.</h1>");
                    }
                    
                }else {
                    out.print("<h1>전화번호는 11자리이어야 합니다.</h1>");
                }
            }else {
                out.print("<h1>이름은 한글이나 영어이어야 합니다.</h1>");
            }

        }else {
            out.print("<h1>이름은 2글자 이상이어야 합니다.</h1>");
        }


        out.close();*/
        
        /*
        * 조건문을 Boolean 형식으로 다 바꿔서 && 로 한번에 유효성 검사
        * */

        Boolean isNameValid = username != null && username.trim().length() >= 2 && Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z]*$", username);
        Boolean isTelValid = tel != null && Pattern.matches("^[0-9]{11}$", tel);
        Boolean isPasswordValid = password != null && password.length() >= 8;
        Boolean isPasswordCheckValid = passwordCheck != null && password.equals(password);

        if(isNameValid && isTelValid && isPasswordValid && isPasswordCheckValid) {
            out.print("<h1>환영 합니다 " + username + "님 </h1>");
        }else {
            out.print("<h1>입력 정보를 확인해주세요.</h1>");
        }

        out.close();

    }
}
