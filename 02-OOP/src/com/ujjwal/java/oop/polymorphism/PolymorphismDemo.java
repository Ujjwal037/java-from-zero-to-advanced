package com.ujjwal.java.oop.polymorphism;

public class PolymorphismDemo {

    public static void main(String[] args) {

        // Upcasting (Runtime Polymorphism)
        Shape shape = new Circle();
        shape.draw(); // Circle's draw() executes
        shape.radius();

        // Downcasting
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            circle.radius();
            circle.draw();
        }
    }
}


