package com.ujjwal.java.designpattern.Creational.PrototypePattern;

public class Main {

    public static void main(String[] args)
            throws CloneNotSupportedException {

        Employee original =
                new Employee("Ujjwal", "Java Developer");

        Employee copy = original.clone();

        System.out.println(original);
        System.out.println(copy);
    }
}

//Traditional Approach (Problem) : -  creating object manually and repeatedly will consume so much of the time and involve so much effort
//Employee emp1 = new Employee(...);
//Employee emp2 = new Employee(...);
//Employee emp3 = new Employee(...);
//Employee emp4 = new Employee(...);
//
//Problems: Performance Cost
//Object creation may be expensive.
//Repeated Initialization
//Same setup repeated again and again.
//Duplicate Code
//Too much boilerplate.

//Prototype Pattern: - Create new objects by copying an existing object, instead of creating them from scratch.
//In simple terms: - Clone existing object ,instead of constructing a new one.

//Think of: -Photocopy Machine
//Instead of writing an entire document again:
//Original Document
//        ↓
//      Copy
//Prototype works exactly like that.

//Instead of: - new Employee(...)
//Use:employee.clone();
//6. Components of Prototype Pattern
        //Prototype consists of:
        //Prototype Interface
        //Concrete Prototype
        //Client

//Internal Working of clone()
//
//When: original.clone();
//is executed: JVM performs:
//Memory Copy
//instead of: - Constructor Execution
//This is why cloning is often faster.
//
//9. Understanding Memory
//Original Object: Employee
                // ├── name = Ujjwal
                // └── designation = Java Developer
//Clone : Employee
        // ├── name = Ujjwal
        // └── designation = Java Developer
//Values copied.