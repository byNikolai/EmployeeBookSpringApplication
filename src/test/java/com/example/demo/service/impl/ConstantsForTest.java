package com.example.demo.service.impl;

import com.example.demo.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ConstantsForTest {

    public static final String FIRST_NAME1 = "Vasili";
    public static final String LAST_NAME1= "Pupkin";

    public static final String FIRST_NAME2 = "Boris";
    public static final String LAST_NAME2 = "Kotov";

    public static final int SALARY = 1000;
    public static final int MAX_SALARY = 10000;
    public static final int DEPARTMENT_ID = 1;
    public static final int DEPARTMENT2_ID = 2;

    public static final Employee EMPLOYEE_WITH_MAX_SALARY = new Employee(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID);
    public static final Employee EMPLOYEE_WITH_MIN_SALARY = new Employee(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
    public static final Employee EMPLOYEE_FROM_OTHER_DEPARTMENT = new Employee(FIRST_NAME2, LAST_NAME1, SALARY, DEPARTMENT2_ID);

    public static final List<Employee> EMPLOYEES = List.of(EMPLOYEE_WITH_MAX_SALARY, EMPLOYEE_WITH_MIN_SALARY);
    public static final List<Employee> EMPLOYEES_FROM_DIFFERENT_DEPARTMENTS = List.of(EMPLOYEE_WITH_MAX_SALARY, EMPLOYEE_FROM_OTHER_DEPARTMENT);
    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENTS = EMPLOYEES_FROM_DIFFERENT_DEPARTMENTS.stream().collect(groupingBy(Employee::getDepartmentID));

}
