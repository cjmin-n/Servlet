package com.ohgiraffers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/writepost")
public class WritePostServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String content =  req.getParameter("cont");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Boolean isTitleValid = title != null && title.trim().length() >=5;
        Boolean isContentValid = content != null && content.trim().length() >=10;

        if(isTitleValid && isContentValid) {
            System.out.println("this");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>게시글이 작성되었습니다</h1>\n")
                    .append("<h2>")
                    .append("제목 : ")
                    .append(title)
                    .append("</h2>\n")
                    .append("<h3>")
                    .append(content)
                    .append("</h3>\n")
                    .append("</body>\n")
                    .append("</html>");
            out.print(stringBuilder);

        }/*else if(!isTitleValid) {
            out.print("<h3>제목은 5자 이상이어야 합니다.</h3>");
        }else if(!isContentValid) {
            out.print("<h3>내용은 10자 이상이어야 합니다.</h3>");
        }*/


        out.flush();
        out.close();
    }
}
