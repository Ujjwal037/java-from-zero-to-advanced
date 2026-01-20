package com.ujjwal.java.oop.basic;

public class StaticBlockDemo {

    static {
        System.out.println("Static block executed");
    }

    public StaticBlockDemo() {
        System.out.println("Constructor executed");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
        new StaticBlockDemo();
    }
}

