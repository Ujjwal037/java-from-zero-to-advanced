package com.ujjwal.java.oop.basic;

public class ObjectCreationOrderDemo {

    static {
        System.out.println("1. Static block");
    }

    {
        System.out.println("2. Instance block");
    }

    ObjectCreationOrderDemo() {
        System.out.println("3. Constructor");
    }

    public static void main(String[] args) {
        System.out.println("4. Main method");
        new ObjectCreationOrderDemo();
    }
}

