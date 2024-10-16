package com.ohgiraffers;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String name = session.getAttribute("userId").toString();

        PrintWriter out = resp.getWriter();
        StringBuilder page = new StringBuilder();
        page.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>환영합니다! ")
                .append(name)
                .append("님!</h1>\n")
                .append("<a href=\"login.jsp\">로그아웃</a>")
                .append("</body>\n")
                .append("</html>");

        out.println(page);
        out.flush();
        out.close();


    }
}
