package com.example.demo.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String firstName;
    private final String lastName;

    private final int salary;
    private final int departmentID;


    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = random.nextInt(1000) + 1000;
        this.departmentID = random.nextInt(5) + 1;

    }

    public Employee(String firstName, String lastName, int salary, int departmentID) {
        this.salary = salary;
        this.departmentID = departmentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ";"
                + " Last Name: " + lastName +
                ";";
    }
}
