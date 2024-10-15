package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 톰캣 서버 기본 인코딩 설정 방식
        System.out.println(req.getCharacterEncoding()); // UTF-8
        
        // 인코딩 방식 지정 가능
        req.setCharacterEncoding("UTF-8"); 

        String name = req.getParameter("name");
        System.out.println("name = " + name);
        // 인코딩을 제외한 값들은 GET 방식과 동일하게 꺼낼 수 있다.

        Map <String, String[]> requestMap = req.getParameterMap();
        Set<String> keySet = requestMap.keySet();
        Iterator<String> keyIter = keySet.iterator();

        while(keyIter.hasNext()){
            String key = keyIter.next();
            String[] value = requestMap.get(key);

            System.out.println("key : " + key);
            for (int i = 0; i < value.length; i++) {
                System.out.println("value[" + i + "] : " + value[i]);
            }
        }
    }

}
