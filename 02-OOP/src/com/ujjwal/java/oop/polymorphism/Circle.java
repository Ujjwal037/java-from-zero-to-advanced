package com.ujjwal.java.oop.polymorphism;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public void radius() {
        System.out.println("Circle radius logic");
    }
}

