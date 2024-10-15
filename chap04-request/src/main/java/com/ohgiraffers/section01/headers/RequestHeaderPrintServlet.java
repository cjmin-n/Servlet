package com.ohgiraffers.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*
        * 헤더의 종류는 전통적으로 4가지 카테고리로 구분된다.
        * 1. General header : 요청 및 응답 모두 적용되지만 body 와는 관련 없는 헤더
        * 2. Request header : fetch 될 리소스나 클라이언트 자체에 대한 상세 정보를 포함하는 헤더
        * 3. Response header : 위치나 서버 자체와 같은 응답에 대한 부가적인 정보를 갖는 헤더
        * 4. Entity header : 컨텐츠 길이나 엔티티 body 에 대한 상세 정보를 포함하는 헤더
        *
        * 출력 시 나오는 헤더는 요청헤더(Request header) 이다.
        * */

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        // accept : 요청을 보낼 때 서버에게 요청할 응답 타입 명시
        System.out.println("accept : " + req.getHeader("accept"));
        // text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7

        // accept-encoding : 응답 시 원하는 인코딩 방식
        System.out.println("accpet-encoding : " + req.getHeader("accpet-encoding"));
        // null

        // accept-language : 응답 시 원하는 언어
        System.out.println("accept-language : " + req.getHeader("accept-language"));
        // ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

        // connection : HTTP 통신이 완료된 후에 네트워크 접속을 유지할지 결정(기본값 - keep-alive = 연결유지)
        System.out.println("connection : " + req.getHeader("connection"));
        // keep-alive

        // host : 서버의 도메인 네임과 현재 Listening 중인 TCP 포트 지정
        System.out.println("host : " + req.getHeader("host"));
        // localhost:8080

        // referer : 이 페이지 이전에 대한 주소
        System.out.println("referer : " + req.getHeader("referer"));
        //  http://localhost:8080/

        // sec-fetch-dest : 요청 대상
        System.out.println("sec-fetch-dest : " + req.getHeader("sec-fetch-dest"));
        // document

        // sec-fetch-mode : 요청 모드
        System.out.println("sec-fetch-mode : " + req.getHeader("sec-fetch-mode"));
        // navigate

        // sec-fetch-user : 사용자가 시작한 요청일 때만 보내짐
        System.out.println("sec-fetch-user : " + req.getHeader("sec-fetch-user"));
        // ?1

        // cache-control : 캐시 설정
        System.out.println("cache-control : " + req.getHeader("cache-control"));
        // null

        // user-agent : 현재 사용자가 어떤 클라이언트를 이용해 보낸 요청인지 명시
        System.out.println("user-agent : " + req.getHeader("user-agent"));
        // Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36

    }
}
