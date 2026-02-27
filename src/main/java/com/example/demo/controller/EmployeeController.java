package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/employee/")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final AuthenticationManager authenticationManager;
    public EmployeeController(EmployeeService employeeService, AuthenticationManager authenticationManager) {
        this.employeeService = employeeService;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @PostMapping("login")
    public String login(@RequestParam String email,@RequestParam String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authenticate = authenticationManager.authenticate(token);

        return employeeService.login(email, password);
    }
}
