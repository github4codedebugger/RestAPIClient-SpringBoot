package com.client.controller;

import com.client.model.Employee;
import com.client.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-client")
public class EmployeeResource {


    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmp(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getEmp();
    }
}
