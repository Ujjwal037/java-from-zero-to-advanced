package com.ujjwal.java.concurrency.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCompleteDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1️⃣ runAsync (no return)
        CompletableFuture<Void> runExample =
                CompletableFuture.runAsync(() ->
                        System.out.println("RunAsync executed by: " +
                                Thread.currentThread().getName())
                );

        runExample.get();

        System.out.println("------------------------------------------------");

        // 2️⃣ supplyAsync (returns value)
        CompletableFuture<Integer> supplyExample =
                CompletableFuture.supplyAsync(() -> 10);

        System.out.println("SupplyAsync Result: " + supplyExample.get());

        System.out.println("------------------------------------------------");

        // 3️⃣ thenApply (transform result)
        CompletableFuture<Integer> transformExample =
                CompletableFuture.supplyAsync(() -> 5)
                        .thenApply(x -> x * 2);

        System.out.println("ThenApply Result: " + transformExample.get());

        System.out.println("------------------------------------------------");

        // 4️⃣ thenCompose (dependent async call)
        CompletableFuture<Integer> composeExample =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenCompose(x ->
                                CompletableFuture.supplyAsync(() -> x + 20)
                        );

        System.out.println("ThenCompose Result: " + composeExample.get());

        System.out.println("------------------------------------------------");

        // 5️⃣ thenCombine (combine two independent tasks)
        CompletableFuture<Integer> task1 =
                CompletableFuture.supplyAsync(() -> 50);

        CompletableFuture<Integer> task2 =
                CompletableFuture.supplyAsync(() -> 70);

        CompletableFuture<Integer> combined =
                task1.thenCombine(task2, Integer::sum);

        System.out.println("ThenCombine Result: " + combined.get());

        System.out.println("------------------------------------------------");

        // 6️⃣ Exception Handling
        CompletableFuture<Integer> exceptionExample =
                CompletableFuture.supplyAsync(() -> {
                    if (true) throw new RuntimeException("Failure");
                    return 100;
                }).exceptionally(ex -> {
                    System.out.println("Exception handled: " + ex.getMessage());
                    return 0;
                });

        System.out.println("Exception Result: " + exceptionExample.get());

        System.out.println("------------------------------------------------");

        // 7️⃣ allOf (wait for all tasks)
        CompletableFuture<Void> all =
                CompletableFuture.allOf(task1, task2);

        all.get();
        System.out.println("All tasks completed");
    }
}

