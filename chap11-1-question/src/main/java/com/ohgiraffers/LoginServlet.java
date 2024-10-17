package com.ohgiraffers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        // 로그인 시 입력 받은 값
        String userIdLogin = req.getParameter("userId");
        String passwordLogin = req.getParameter("password");
        
        // 세션
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();

        Boolean isIdValid = false;
        Boolean isPasswordValid = false;

        while (attributeNames.hasMoreElements()) {
            String attr = attributeNames.nextElement();
            
            // 세션 안의 값이 입력받은 값과 일치하는지
            if(attr.equals("userId")){
                isIdValid = userIdLogin.equals(session.getAttribute(attr).toString());
            }

            if(attr.equals("password")) {
                isPasswordValid = passwordEncoder.matches(passwordLogin, session.getAttribute(attr).toString());
            }

        }




        if(isIdValid && isPasswordValid){
            // 아이디 패스워드 둘다 같으면 main으로 리다이렉트(mainServlet으로)
            /*Cookie loginStatus = new Cookie("loginStatus", String.valueOf(isIdValid && isPasswordValid));
            loginStatus.setMaxAge(60 * 60 * 24);
            resp.addCookie(loginStatus);*/

            resp.sendRedirect("main");

        }else if(!isIdValid || !isPasswordValid){
            // 요청에 "errorMessage"이름의 attribute로 저장
            req.setAttribute("errorMessage", "id나 비밀번호가 다릅니다.");
            doGet(req, resp);
        }

       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        StringBuilder page = new StringBuilder();
        // 요청에 저장해놨던 "errorMessage" 꺼내오기
        String errorMessage = (String)req.getAttribute("errorMessage");
        if(errorMessage == null ){
            errorMessage = "";
        }else {
            errorMessage = (String)req.getAttribute("errorMessage");
        }

        page.append("<html>\n")
            .append("<head>\n")
            .append("</head>\n")
            .append("<body>\n")
            .append("<h2>로그인 페이지</h2>\n")
            .append("<form>\n")
            .append("<input type=\"text\" name=\"userId\" placeholder=\"User ID\" required> <input type=\"password\" name=\"password\" placeholder=\"Password\" required>\n" +
                    "<button type=\"submit\">로그인</button>")
            .append("</form>\n")
            .append("<p style=\"color: red;\">")
            .append(errorMessage)
            .append("</p>\n")
            .append("<a href='register.jsp'>가입하기</a>")
            .append("</body>")
            .append("</html>");
        out.print(page);

        out.flush();
        out.close();
    }
}
