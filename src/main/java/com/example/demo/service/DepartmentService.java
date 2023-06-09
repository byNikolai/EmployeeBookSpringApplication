package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee maxWageEmployee(int departmentID);
    Employee minWageEmployee(int departmentID);
    Collection<Employee> findByDepartment(int departmentID);
    Map<Integer, List<Employee>> findByDepartment();
}
