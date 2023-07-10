package com.example.demo.service.impl;

import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee maxWageEmployee(int departmentID) {
        return employeeService.returnAll().stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee minWageEmployee(int departmentID) {
        return employeeService.returnAll().stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Collection<Employee> findByDepartment(int departmentID) {
        return employeeService.returnAll().stream()
                .filter(e -> e.getDepartmentID() == departmentID)
                .sorted(Comparator.comparing(Employee::getLastName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findByDepartment() {
        return employeeService.returnAll().stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }
}
