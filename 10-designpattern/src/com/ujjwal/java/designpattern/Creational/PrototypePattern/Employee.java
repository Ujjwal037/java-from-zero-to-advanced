package com.ujjwal.java.designpattern.Creational.PrototypePattern;

public class Employee implements Cloneable {

    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    @Override
    public String toString() {
        return name + " - " + designation;
    }
}
