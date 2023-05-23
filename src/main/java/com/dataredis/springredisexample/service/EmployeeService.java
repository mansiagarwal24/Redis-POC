package com.dataredis.springredisexample.service;

import com.dataredis.springredisexample.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RedisTemplate redisTemplate;

    public Employee createEmployee(Employee employee){
        redisTemplate.opsForHash().put("Employee",employee.getId(),employee);
        return employee;

    }

    public List<Employee> getAllEmployee(){
        return redisTemplate.opsForHash().values("Employee");
    }

    public Employee findById(Long id){
        return (Employee) redisTemplate.opsForHash().get("Employee",id);
    }

    public String deleteEmployee(Long id){
        redisTemplate.opsForHash().delete("Employee",id);
        return "Employee deleted Successfully!!";
    }
}
