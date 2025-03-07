package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> attrName = req.getAttributeNames();
        while(attrName.hasMoreElements()){
            System.out.println(attrName.nextElement());
        }
        /*
        jakarta.servlet.forward.request_uri
        jakarta.servlet.forward.context_path
        jakarta.servlet.forward.servlet_path
        jakarta.servlet.forward.mapping
        jakarta.servlet.error.message
        jakarta.servlet.error.servlet_name
        jakarta.servlet.error.request_uri
        jakarta.servlet.error.status_code
        * */
        // forward : 요청을 다른 서블릿으로 넘겨서 처리
        // - url 주소창은 바뀌지 않음

        // request_uri : 요청이 포워딩 되었을 때 원래 요청의 uri
        String forwardRequestURI = (String)req.getAttribute("jakarta.servlet.forward.request_uri");

        // context_path : 요청이 포워딩 되었을 때 원래 요청의 컨텍스트 경로
        String contextPath = (String)req.getAttribute("jakarta.servlet.forward.context_path");

        // 어떤 서블릿에 의해 요청이 처리되었는지
        HttpServletMapping mapping = req.getHttpServletMapping();

        // status_code : 요청 처리 중 발생한 오류의 상태 코드
        Integer statusCode = (Integer)req.getAttribute("jakarta.servlet.error.status_code");

        // message : 요청 처리 중 발생한 오류 메시지
        String message = (String)req.getAttribute("jakarta.servlet.error.message");

        // servlet_name : 오류를 발생시킨 서블릿의 이름
        String servletName = (String)req.getAttribute("jakarta.servlet.error.servlet_name");

        System.out.println(forwardRequestURI); // /show404error
        System.out.println(contextPath); //
        System.out.println(mapping); // org.apache.catalina.core.ApplicationMapping$MappingImpl@6157ccb4
        System.out.println(statusCode); // 404
        System.out.println(message); // 페이지를 찾을 수 없습니당
        System.out.println(servletName); // com.ohgiraffers.section01.exception.Show404ErrorServlet
        System.out.println((String)req.getAttribute("jakarta.servlet.forward.servlet_path")); // /show404error
        System.out.println((String)req.getAttribute("jakarta.servlet.error.request_uri")); // /show404error

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append(" - ")
                .append(message)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print(errorPage);
        out.flush();
        out.close();
    }

}
