package com.ujjwal.java.oop.inheritance;

public class Employee extends Person {

    private String employeeId;
    private double salary;

    public Employee(String name, int age, String employeeId, double salary) {
        super(name, age);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}

