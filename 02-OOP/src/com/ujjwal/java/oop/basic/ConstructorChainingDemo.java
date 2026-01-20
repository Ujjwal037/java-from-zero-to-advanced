package com.ujjwal.java.oop.basic;

public class ConstructorChainingDemo {

    ConstructorChainingDemo() {
        this(10);
        System.out.println("Default constructor");
    }

    ConstructorChainingDemo(int x) {
        this(x, "Java");
        System.out.println("Single parameter constructor");
    }

    ConstructorChainingDemo(int x, String y) {
        System.out.println("Two parameter constructor: " + x + ", " + y);
    }

    public static void main(String[] args) {
        new ConstructorChainingDemo();
    }
}

