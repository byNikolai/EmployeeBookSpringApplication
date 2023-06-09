package com.example.demo.service.impl;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeValidationService;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeValidationService validationService;
    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;
        this.employeeMap = new HashMap<>();
//        add("Vasili", "Vasiliev");
//        add("Ivan", "Ivanov");
//        add("Petr", "Petrov");
//        add("Mihail", "Mihailov");
//        add("Nikolay", "Nikolaev");
//        add("Roman", "Romanov");
    }


    @Override
    public Employee add(String firstName, String lastName,  int salary, int departmentID) {

        validationService.validate(firstName, lastName);
        return addEmployee(new Employee(capitalize(firstName), capitalize(lastName), salary, departmentID));
    }
    @Override
    public Employee add(String firstName, String lastName) {

        validationService.validate(firstName, lastName);
        return addEmployee(new Employee(capitalize(firstName), capitalize(lastName)));
    }

    @Override
    public Employee find(String firstName, String lastName) {
//        validateInput(firstName,lastName);

        Employee employee = new Employee(firstName, lastName);
        if (!employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException(employee);
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
//        validateInput(firstName,lastName);

        Employee employee = new Employee(firstName, lastName);

        if (!employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException(employee);
        }
        employeeMap.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Collection<Employee> returnAll() {
        return employeeMap.values();
    }

    private Employee addEmployee(Employee employee) {
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException(employee);
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

//    private void validateInput(String firstName, String lastName) {
//        if (!(isAlpha(firstName) && isAlpha(lastName))) {
//            throw new InvalidInputException();
//        }
//    }
}
