package com.ityan.SpringBoot_Shiro.test;

import com.ityan.SpringBoot_Shiro.domain.Employee;
import com.ityan.SpringBoot_Shiro.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class MyTest {
    @Autowired
    EmployeeService employeeService;
    @Test
    public void getEmployee(){

        employeeService.getPermissionByEid(1L);
    }
}
