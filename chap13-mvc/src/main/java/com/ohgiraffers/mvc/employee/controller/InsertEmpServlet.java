package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        String salLevel = req.getParameter("salLevel");
        int salary = Integer.parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String managerId = req.getParameter("managerId");
        Date hireDate = Date.valueOf(req.getParameter("hireDate"));

        EmployeeService employeeService = new EmployeeService();
        // 제일 마지막 번호를 가져와서 +1 (autoIncrement 없는 데이터의 경우 필요함)
        int newEmpId = employeeService.selectNewEmpId();
        System.out.println("newEmpId = " + newEmpId);

        EmployeeDTO emp = new EmployeeDTO();
        if(newEmpId != 0) emp.setEmpId(newEmpId);
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(managerId);
        emp.setHireDate(hireDate);

        System.out.println("emp = " + emp);

        int result = employeeService.insertEmp(emp);

        String path = "";
        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "insertEmp");
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "신규 직원 등록에 실패했습니다.");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
