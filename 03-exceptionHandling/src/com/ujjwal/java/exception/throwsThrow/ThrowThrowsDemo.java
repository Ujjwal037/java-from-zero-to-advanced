package com.ujjwal.java.exception.throwthrows;

public class ThrowThrowsDemo {

    // Method declaring exception using throws
    static void validateAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Age is valid");
    }

    public static void main(String[] args) {

        try {
            validateAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Program continues...");
    }
}

