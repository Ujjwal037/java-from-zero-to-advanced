package com.ujjwal.java.java8.functionalInterface;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfacesDemo {

    public static void main(String[] args) {

        /* ===============================
           1. Predicate<T>
           =============================== */

        Predicate<Integer> isAdult = age -> age >= 18;

        System.out.println("Predicate:");
        System.out.println("Is 20 adult? " + isAdult.test(20));
        System.out.println("Is 15 adult? " + isAdult.test(15));


        /* ===============================
           2. Function<T, R>
           =============================== */

        Function<String, Integer> stringLength = str -> str.length();

        System.out.println("\nFunction:");
        System.out.println("Length of 'Java': " + stringLength.apply("Java"));


        /* ===============================
           3. Consumer<T>
           =============================== */

        Consumer<String> printer = msg -> System.out.println("Message: " + msg);

        System.out.println("\nConsumer:");
        printer.accept("Hello Functional Interface");


        /* ===============================
           4. Supplier<T>
           =============================== */

        Supplier<Date> currentDateSupplier = () -> new Date();

        System.out.println("\nSupplier:");
        System.out.println("Current Date: " + currentDateSupplier.get());


        /* ===============================
           5. BiPredicate<T, U>
           =============================== */

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;

        System.out.println("\nBiPredicate:");
        System.out.println("Is 10 > 5? " + isGreater.test(10, 5));


        /* ===============================
           6. BiFunction<T, U, R>
           =============================== */

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println("\nBiFunction:");
        System.out.println("10 + 20 = " + add.apply(10, 20));


        /* ===============================
           7. UnaryOperator<T>
           =============================== */

        UnaryOperator<Integer> square = x -> x * x;

        System.out.println("\nUnaryOperator:");
        System.out.println("Square of 5 = " + square.apply(5));


        /* ===============================
           8. BinaryOperator<T>
           =============================== */

        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

        System.out.println("\nBinaryOperator:");
        System.out.println("Max of 10 and 20 = " + max.apply(10, 20));


        /* ===============================
           9. Practical Real-World Example
           =============================== */

        List<String> names = Arrays.asList("Ujjwal", "Aman", "Raj", "Vikas");

        System.out.println("\nReal-World Example:");

        names.stream()
                .filter(name -> name.length() > 3)     // Predicate
                .map(String::toUpperCase)               // Function
                .forEach(System.out::println);          // Consumer
    }
}

