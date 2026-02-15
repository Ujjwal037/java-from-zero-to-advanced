package com.ujjwal.java.concurrency.parallelStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamDeepDiveDemo {

    public static void main(String[] args) {

        List<Integer> numbers = IntStream.rangeClosed(1, 5_000_000)
                .boxed()
                .collect(Collectors.toList());

        // 1️⃣ Sequential Stream Timing
        long startSeq = System.currentTimeMillis();

        long seqSum = numbers.stream()
                .mapToLong(i -> i * 2)
                .sum();

        long endSeq = System.currentTimeMillis();

        System.out.println("Sequential Sum: " + seqSum);
        System.out.println("Sequential Time: " + (endSeq - startSeq) + " ms");

        System.out.println("------------------------------------------------");

        // 2️⃣ Parallel Stream Timing
        long startPar = System.currentTimeMillis();

        long parSum = numbers.parallelStream()
                .mapToLong(i -> i * 2)
                .sum();

        long endPar = System.currentTimeMillis();

        System.out.println("Parallel Sum: " + parSum);
        System.out.println("Parallel Time: " + (endPar - startPar) + " ms");

        System.out.println("------------------------------------------------");

        // 3️⃣ Show Thread Usage
        numbers.parallelStream()
                .limit(10)
                .forEach(i ->
                        System.out.println("Processed by: "
                                + Thread.currentThread().getName())
                );

        System.out.println("------------------------------------------------");

        // 4️⃣ Custom ForkJoinPool
        ForkJoinPool customPool = new ForkJoinPool(4);

        try {
            long customResult = customPool.submit(() ->
                    numbers.parallelStream()
                            .mapToLong(i -> i)
                            .sum()
            ).get();

            System.out.println("Custom Pool Result: " + customResult);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customPool.shutdown();
        }
    }
//    What This Demonstrates
//    ✔ Sequential vs Parallel Performance
//    Depends on CPU cores
//    Depends on dataset size
//    ✔ Default Thread Pool
//    Parallel stream uses:
//            ForkJoinPool.commonPool()
//            ✔ Custom ForkJoinPool
//    You can override common pool if needed.
}

