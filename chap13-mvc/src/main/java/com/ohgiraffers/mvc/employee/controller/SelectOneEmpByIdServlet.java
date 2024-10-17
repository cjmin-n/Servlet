package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int empId = Integer.parseInt(req.getParameter("empId"));

        System.out.println("empId = " + empId);

        // 사번을 이용해 사원 정보를 조회하는 비즈니스 로직을 호출
        EmployeeService empService = new EmployeeService();
        EmployeeDTO selectEmp = empService.selectOneEmpById(empId);

        System.out.println("selectEmp = " + selectEmp);

        // 실행 결과에 따라서 뷰 연결
        String path = "";

        if(selectEmp != null) {
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            req.setAttribute("selectEmp", selectEmp);
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "직원 정보 조회 실패");
        }

        req.getRequestDispatcher(path).forward(req, resp);


    }
}
