package com.example.demo.service.impl;

import com.example.demo.exceptions.*;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeValidationService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.example.demo.service.impl.ConstantsForTest.*;
class EmployeeServiceImplTest {

    private final EmployeeValidationServiceImpl validationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);
@Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);

        assertFalse(employeeService.returnAll().contains(employee));
        assertEquals(0, employeeService.returnAll().size());

        Employee addedEmployee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);

        assertEquals(employee, addedEmployee);
        assertEquals(1, employeeService.returnAll().size());
        assertTrue(employeeService.returnAll().contains(employee));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        Employee employee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertTrue(employeeService.returnAll().contains(employee));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnExistingEmployee() {
        Employee employee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertEquals(employee, employeeService.find(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeNotFound() {
        assertEquals(0, employeeService.returnAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(FIRST_NAME1, LAST_NAME1));
    }
    @Test
    public void shouldRemoveEmployee() {
        Employee employee = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertEquals(1, employeeService.returnAll().size());
        assertTrue(employeeService.returnAll().contains(employee));

        Employee removedEmployee = employeeService.remove(FIRST_NAME1, LAST_NAME1);
        assertEquals(employee, removedEmployee);
        assertEquals(0, employeeService.returnAll().size());
        assertFalse(employeeService.returnAll().contains(employee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemovingEmployee() {
        assertEquals(0, employeeService.returnAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void shouldReturnAllEmployees() {
        Employee employee1 = employeeService.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        Employee employee2 = employeeService.add(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);

        Collection<Employee> addedEmployees = employeeService.returnAll();

        assertIterableEquals(List.of(employee1, employee2), addedEmployees);
    }
}