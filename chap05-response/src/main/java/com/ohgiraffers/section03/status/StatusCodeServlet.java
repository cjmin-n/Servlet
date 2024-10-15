package com.ohgiraffers.section03.status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/status")
public class StatusCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 특정 상황에 에러를 만들어 보내준다.
        // resp.sendError(404, "없는 페이지 입니다. 경로를 확인 해주세요."); // sendError(에러코드, 메시지)

        // 404 : 클라이언트의 잘못된 요청으로 나타난 에러
        resp.sendError(500, "서버 내부 오류입니다. 서버 오류는 개발자의 잘못이고, 개발자는 여러분입니다.");
        // 500 : 서버 에러
    }
}
