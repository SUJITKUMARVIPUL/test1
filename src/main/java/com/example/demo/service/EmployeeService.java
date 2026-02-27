package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;



    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public String login(String email, String password) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            return "login failed";
        }
        if (employee.getPassword().equals(password)) {
            return "login ok";
        }
        return "login failed";
    }

}
