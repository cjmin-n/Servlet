package com.ohgiraffers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {

        String value = "";
        if("password".equals(name)){
            // name=password 만 암호화
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));

        }else {
            // 나머지는 입력받은 그대로
            value = super.getParameter(name);
        }

        return value;
    }
}
