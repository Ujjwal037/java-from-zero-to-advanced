package com.ujjwal.java.java8.lambda;

import java.util.*;

public class LambdaExpressionDemo {

    public static void main(String[] args) {

        /* =========================================
           1. Lambda vs Anonymous Class
           ========================================= */

        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running using Anonymous Class");
            }
        };

        Runnable lambdaRunnable = () ->
                System.out.println("Running using Lambda Expression");

        anonymousRunnable.run();
        lambdaRunnable.run();


        /* =========================================
           2. Lambda with Parameters
           ========================================= */

        Comparator<Integer> comparatorAnonymous = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };

        Comparator<Integer> comparatorLambda = (a, b) -> a - b;

        System.out.println("\nComparator using Lambda:");
        System.out.println(comparatorLambda.compare(10, 20));


        /* =========================================
           3. Lambda with Functional Interface
           ========================================= */

        Greeting greeting = (name) ->
                System.out.println("Hello, " + name);

        greeting.sayHello("Ujjwal");


        /* =========================================
           4. Lambda with Return Value
           ========================================= */

        Calculator addition = (a, b) -> a + b;

        System.out.println("\nLambda with return value:");
        System.out.println("10 + 20 = " + addition.calculate(10, 20));


        /* =========================================
           5. Lambda with Collections
           ========================================= */

        List<String> names = Arrays.asList("Ujjwal", "Aman", "Raj", "Vikas");

        System.out.println("\nLambda with forEach:");
        names.forEach(name -> System.out.println(name));


        /* =========================================
           6. Lambda with Stream
           ========================================= */

        System.out.println("\nLambda with Stream:");
        names.stream()
                .filter(name -> name.length() > 3)
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name));


        /* =========================================
           7. Lambda Scope & Effectively Final
           ========================================= */

        int factor = 10;

        Multiplier multiplier = (x) -> x * factor;
        System.out.println("\nLambda Scope:");
        System.out.println("Result: " + multiplier.multiply(5));


        /* =========================================
           8. Lambda Limitations
           ========================================= */

        System.out.println("\nLambda Limitations:");
        System.out.println("- Works only with Functional Interfaces");
        System.out.println("- Cannot change local variable value");
        System.out.println("- No state like classes");
    }
}

/* =========================================
   Functional Interfaces used
   ========================================= */

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface Multiplier {
    int multiply(int value);
}

