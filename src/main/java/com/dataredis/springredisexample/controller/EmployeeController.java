package com.dataredis.springredisexample.controller;

import com.dataredis.springredisexample.entity.Employee;
import com.dataredis.springredisexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee findOne(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
