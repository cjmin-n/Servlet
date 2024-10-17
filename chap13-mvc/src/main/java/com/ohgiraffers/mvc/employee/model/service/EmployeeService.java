package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeService {

    private final EmployeeDAO empDAO;

    public EmployeeService() {
        empDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmpByID (String empId){

    }
}
