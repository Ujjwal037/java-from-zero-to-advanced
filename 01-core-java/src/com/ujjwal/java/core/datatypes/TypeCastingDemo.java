package com.ujjwal.java.core.datatypes;

public class TypeCastingDemo {

    public static void main(String[] args) {

        // Widening casting (automatic)
        int intValue = 100;
        double doubleValue = intValue;

        // Narrowing casting (explicit)
        double price = 99.99;
        int roundedPrice = (int) price;

        // Data loss example
        int bigNumber = 130;
        byte smallNumber = (byte) bigNumber;

        // char to int
        char letter = 'A';
        int asciiValue = letter;

        System.out.println("doubleValue: " + doubleValue);
        System.out.println("roundedPrice: " + roundedPrice);
        System.out.println("smallNumber: " + smallNumber);
        System.out.println("asciiValue: " + asciiValue);
    }
}

