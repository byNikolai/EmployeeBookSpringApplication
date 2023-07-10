package com.example.demo.service.impl;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.demo.service.impl.ConstantsForTest.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.example.demo.exceptions.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByDepartmentID() {
        when(employeeService.returnAll()).thenReturn(EMPLOYEES);

        assertEquals(EMPLOYEE_WITH_MAX_SALARY, departmentService.maxWageEmployee(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeWithMaxSalaryByDepartmentIDNotFound() {
        when(employeeService.returnAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.maxWageEmployee(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMaxSalaryByCorrectDepartmentID() {
        when(employeeService.returnAll()).thenReturn(EMPLOYEES);

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.maxWageEmployee(DEPARTMENT2_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMinSalaryByDepartmentID() {
        when(employeeService.returnAll()).thenReturn(EMPLOYEES);

        assertEquals(EMPLOYEE_WITH_MIN_SALARY, departmentService.maxWageEmployee(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeWithMinSalaryByDepartmentIDNotFound() {
        when(employeeService.returnAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.minWageEmployee(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmployeeWithMinSalaryByCorrectDepartmentID() {
        when(employeeService.returnAll()).thenReturn(EMPLOYEES);

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.minWageEmployee(DEPARTMENT2_ID));
    }
    @Test
    public void shouldReturnEmployeeByDepartmentID() {
        when(employeeService.returnAll()).thenReturn(EMPLOYEES_FROM_DIFFERENT_DEPARTMENTS);

        assertEquals(singletonList(EMPLOYEE_WITH_MAX_SALARY), departmentService.findByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(EMPLOYEE_FROM_OTHER_DEPARTMENT), departmentService.findByDepartment(DEPARTMENT2_ID));
    }

    @Test
    public void shouldReturnEmptyMapByDepartments() {
        when(employeeService.returnAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), departmentService.findByDepartment());
    }
    @Test
    public void shouldReturnNotEmptyMapByDepartments() {
        when(employeeService.returnAll()).thenReturn(EMPLOYEES_FROM_DIFFERENT_DEPARTMENTS);
        assertEquals(EMPLOYEES_BY_DEPARTMENTS, departmentService.findByDepartment());
    }

}