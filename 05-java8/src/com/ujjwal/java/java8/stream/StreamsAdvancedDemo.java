package com.ujjwal.java.java8.stream;

import java.util.*;
import java.util.stream.*;

public class StreamsAdvancedDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        /* =========================================
           1. reduce() – Aggregation
           ========================================= */

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum using reduce: " + sum);


        /* =========================================
           2. reduce() without identity
           ========================================= */

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);

        max.ifPresent(m -> System.out.println("Max value: " + m));


        /* =========================================
           3. findFirst & findAny
           ========================================= */

        Optional<Integer> first = numbers.stream().findFirst();
        Optional<Integer> any = numbers.stream().findAny();

        System.out.println("\nfindFirst: " + first.orElse(null));
        System.out.println("findAny: " + any.orElse(null));


        /* =========================================
           4. allMatch, anyMatch, noneMatch
           ========================================= */

        boolean allGreaterThanFive = numbers.stream()
                .allMatch(n -> n > 5);

        boolean anyGreaterThanForty = numbers.stream()
                .anyMatch(n -> n > 40);

        boolean noneNegative = numbers.stream()
                .noneMatch(n -> n < 0);

        System.out.println("\nallMatch >5: " + allGreaterThanFive);
        System.out.println("anyMatch >40: " + anyGreaterThanForty);
        System.out.println("noneMatch <0: " + noneNegative);


        /* =========================================
           5. Parallel Stream
           ========================================= */

        System.out.println("\nParallel Stream execution:");
        numbers.parallelStream()
                .forEach(n ->
                        System.out.println(n + " - " + Thread.currentThread().getName())
                );


        /* =========================================
           6. Sequential vs Parallel
           ========================================= */

        System.out.println("\nSequential Stream:");
        numbers.stream()
                .forEach(n ->
                        System.out.println(n + " - " + Thread.currentThread().getName())
                );


        /* =========================================
           7. Performance Note
           ========================================= */

        System.out.println("\nPerformance Notes:");
        System.out.println("- Parallel streams use ForkJoinPool");
        System.out.println("- Not always faster");
        System.out.println("- Best for CPU-intensive tasks");
    }
}

