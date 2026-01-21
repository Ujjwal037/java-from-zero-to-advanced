package com.ujjwal.java.oop.basic;

public class InstanceInitializationBlockDemo {

    {
        System.out.println("Instance initialization block");
    }

    InstanceInitializationBlockDemo() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new InstanceInitializationBlockDemo();
        new InstanceInitializationBlockDemo();
    }
}

