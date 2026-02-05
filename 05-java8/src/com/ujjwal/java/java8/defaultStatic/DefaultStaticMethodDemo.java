package com.ujjwal.java.java8.defaultStatic;

public class DefaultStaticMethodDemo {

    public static void main(String[] args) {

        Vehicle car = new Car();
        car.start();        // implemented method
        car.honk();         // default method

        Vehicle.service();  // static method
    }
}

/* =========================================
   Interface with default & static methods
   ========================================= */

interface Vehicle {

    void start(); // abstract method

    // Default method (Java 8)
    default void honk() {
        System.out.println("Vehicle is honking");
    }

    // Static method (Java 8)
    static void service() {
        System.out.println("Vehicle is under service");
    }
}

/* =========================================
   Implementing class
   ========================================= */

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    // Optional override of default method
    @Override
    public void honk() {
        System.out.println("Car honking");
    }
}

interface A {
    default void show() {}
}

interface B {
    default void show() {}
}

class C implements A, B {
    @Override
    public void show() {
        A.super.show(); // explicit resolution
    }
}

