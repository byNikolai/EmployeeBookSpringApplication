package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int salary, int departmentID);

    Employee add(String firstName, String lastName);

    Employee find(String firstName, String lastName);
    Employee remove(String firstName, String lastName);

    Collection<Employee> returnAll();
}
