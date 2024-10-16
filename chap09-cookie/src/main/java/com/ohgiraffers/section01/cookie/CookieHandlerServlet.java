package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);



        /*
        * 쿠키를 사용하는 방법은 간단하며, 다음과 같다.
        * 1. 쿠키를 생성한다.                  : new Cookie(name, value)
        * 2. 생성한 쿠키의 만료 시간을 설정한다.  : setMaxAge(초)
        * 3. 응답 헤더에 쿠키를 담는다.         : resp.addCookie(쿠키이름)
        * 4. 응답을 보낸다.                    : resp.sendRedirect(리다이렉트할 곳)
        *
        * 하지만 쿠키는 일부 제약사항이 있다.
        * 1. 한 번 설정한 쿠키의 이름은 변경할 수 없다.
        * 2. 쿠키의 이름에는 공백문자와 일부 특수문자( [] () , = " \ @ ? : ; )
        * 를 사용할 수 없다.
        *
        * */

        // Cookie 는 기본 생성자가 없기 때문에 꼭 파라미터를 담아줘야한다.
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        // 시간 설정이 없으면 브라우저가 꺼질 때 사라진다. 사용 용도에 따라 시간 설정을 해두는 것이 좋다.
        firstNameCookie.setMaxAge(60 * 60 * 24); // 하루 ( 초 기준 )
        lastNameCookie.setMaxAge(60 * 60 * 24);

        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        resp.sendRedirect("redirect");
    }
}

/*
* 쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다.
* 그렇기 때문에 개인 PC 는 크게 상관이 없지만 공용 PC 등 다른 사용자와
* 함께 쓰는 컴퓨터이면 보안에 취약하다.
* 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다는 세션을 이용한다.
* 세션은 쿠키와 유사한 형태로 저장되지만 서버에서 관리되므로 보안에 더 우수하다는 장점을 가진다.
* (서버는 현재 톰캣..)
* */
