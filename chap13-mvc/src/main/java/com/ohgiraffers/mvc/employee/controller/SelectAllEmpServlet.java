package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDTO> employeeList = employeeService.selectAllEmp();


        String path = "";
        if(employeeList != null || !employeeList.isEmpty()) {

            req.setAttribute("empList", employeeList);
            path = "/WEB-INF/views/employee/employeeList.jsp";
        }else {
            path= "/WEB-INF/views/common/errorPage.jsp";
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
