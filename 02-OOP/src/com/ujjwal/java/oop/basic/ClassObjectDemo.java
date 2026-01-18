package com.ujjwal.java.oop.basic;

class Car {
    String brand;
    int speed;

    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }
}

public class ClassObjectDemo {

    public static void main(String[] args) {

        Car car1 = new Car();
        car1.brand = "Tesla";
        car1.speed = 120;
        car1.drive();

        Car car2 = new Car();
        car2.brand = "BMW";
        car2.speed = 100;
        car2.drive();
    }
}

