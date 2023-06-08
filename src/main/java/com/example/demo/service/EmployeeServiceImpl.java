package com.example.demo.service;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFullName())) {
           return employeeMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> returnAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
