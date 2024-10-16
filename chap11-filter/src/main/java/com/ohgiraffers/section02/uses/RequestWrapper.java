package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    /*
    * HttpServletRequestWrapper 클래스는 HttpServletRequest 인터페이스를
    * 구현해놓은 클래스이다.
    * 이 클래스는 request 객체의 요청 정보를 수정하거나 확장하는 용도로 사용한다.
    * 특정 파라미터의 값을 변경하거나 새로운 파라미터를 추가할 수 있다.
    *
    * */
    
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {

        String value = "";

        if("password".equals(name)) {
            
            // 비밀번호만 암호화
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));


        }else {
            value = super.getParameter(name);
        }

        return value;
    }
}
