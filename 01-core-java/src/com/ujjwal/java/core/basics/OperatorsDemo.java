package com.ujjwal.java.core.basics;

public class OperatorsDemo {

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // Arithmetic
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(b % a);

        // Relational
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);

        // Logical
        boolean x = true;
        boolean y = false;
        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(!x);

        // Assignment
        int c = 10;
        c += 5;
        System.out.println(c);

        // Unary
        int d = 5;
        System.out.println(++d);
        System.out.println(d--);
    }
}

