package com.ujjwal.java.oop.encapsulation;

public class AccessTest {

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo();

        // demo.privateVar ❌ not accessible
        System.out.println(demo.defaultVar);
        System.out.println(demo.protectedVar);
        System.out.println(demo.publicVar);
    }
}

