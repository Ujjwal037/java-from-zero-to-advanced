package com.ujjwal.java.oop.basic;

public class ConstructorCallFlow {

    ConstructorCallFlow() {
        System.out.println("Constructor executed");
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        ConstructorCallFlow obj = new ConstructorCallFlow();
        System.out.println("Main ended");
    }
}

