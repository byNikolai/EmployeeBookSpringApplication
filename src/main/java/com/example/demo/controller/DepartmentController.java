package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryEmployee(@RequestParam int departmentID) {
        return departmentService.maxWageEmployee(departmentID);
    }
    @GetMapping("/min-salary")
    public Employee findMinSalaryEmployee(@RequestParam int departmentID) {
        return departmentService.minWageEmployee(departmentID);
    }
    @GetMapping(value = "/all", params = {"departmentID"})
    public Employee findEmployeeByDepartment(@RequestParam int departmentID) {
        return (Employee) departmentService.findByDepartment(departmentID);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return departmentService.findByDepartment();
    }
}
