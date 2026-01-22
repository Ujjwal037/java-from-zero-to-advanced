package com.ujjwal.java.oop.encapsulation;

public class AccessModifierDemo {

    private int privateVar = 1;
    int defaultVar = 2;
    protected int protectedVar = 3;
    public int publicVar = 4;

    public void display() {
        System.out.println(privateVar);
        System.out.println(defaultVar);
        System.out.println(protectedVar);
        System.out.println(publicVar);
    }
}

