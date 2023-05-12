package com.example.demo.service;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> returnAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
