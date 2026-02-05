package com.ujjwal.java.java8.stream;

import java.util.*;
import java.util.stream.*;

public class StreamsBasicsDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        /* =========================================
           1. What is a Stream?
           ========================================= */

        System.out.println("Original List:");
        numbers.forEach(System.out::println);


        /* =========================================
           2. Filter (Predicate)
           ========================================= */

        System.out.println("\nFilter even numbers:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);


        /* =========================================
           3. Map (Function)
           ========================================= */

        System.out.println("\nMap: Square each number:");
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);


        /* =========================================
           4. Sorted
           ========================================= */

        System.out.println("\nSorted (natural order):");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);


        /* =========================================
           5. Sorted with Comparator
           ========================================= */

        System.out.println("\nSorted (descending):");
        numbers.stream()
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);


        /* =========================================
           6. Limit & Skip
           ========================================= */

        System.out.println("\nLimit first 3 elements:");
        numbers.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nSkip first 2 elements:");
        numbers.stream()
                .skip(2)
                .forEach(System.out::println);


        /* =========================================
           7. Count
           ========================================= */

        long count = numbers.stream()
                .filter(n -> n > 15)
                .count();

        System.out.println("\nCount > 15: " + count);


        /* =========================================
           8. Distinct
           ========================================= */

        List<Integer> duplicates = Arrays.asList(10, 20, 10, 30, 20);

        System.out.println("\nDistinct elements:");
        duplicates.stream()
                .distinct()
                .forEach(System.out::println);


        /* =========================================
           9. Collect
           ========================================= */

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("\nCollected Even Numbers:");
        evenNumbers.forEach(System.out::println);


        /* =========================================
           10. forEach (Terminal Operation)
           ========================================= */

        System.out.println("\nforEach terminal operation:");
        numbers
                .forEach(n -> System.out.println("Value: " + n));
    }
}

