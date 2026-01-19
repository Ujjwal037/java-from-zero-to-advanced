package com.ujjwal.java.oop.basic;

public class ConstructorBasics {

    int id;
    String name;

    // Default constructor
    ConstructorBasics() {
        System.out.println("Default constructor called");
    }

    // Parameterized constructor
    ConstructorBasics(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        ConstructorBasics obj1 = new ConstructorBasics();
        ConstructorBasics obj2 = new ConstructorBasics(1, "Ujjwal");

        obj2.display();
    }
}
