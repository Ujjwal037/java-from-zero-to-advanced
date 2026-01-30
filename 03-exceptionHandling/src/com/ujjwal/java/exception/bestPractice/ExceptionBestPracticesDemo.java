package com.ujjwal.java.exception.bestPractice;

public class ExceptionBestPracticesDemo {

    static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be zero");
        }
        return a / b;
    }

    public static void main(String[] args) {

        try {
            int result = divide(10, 0);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            // Log and rethrow if needed (here we just print)
            System.out.println("Error: " + e.getMessage());
        }
    }
}

