package com.ityan.SpringBoot_Shiro.controller;

import com.ityan.SpringBoot_Shiro.domain.Employee;
import com.ityan.SpringBoot_Shiro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/hello")
    public String  hello(){
        System.out.println("来了老弟");
        Employee zy = employeeService.getEmplByUsername("zy");
        System.out.println(zy);
        return "test";
    }
}
