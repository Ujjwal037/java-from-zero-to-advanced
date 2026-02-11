package com.ujjwal.java.concurrency.executor;
import java.util.concurrent.*;

public class ExecutorServiceCompleteDemo {

    public static void main(String[] args) throws Exception {

        // 1️⃣ Fixed Thread Pool
        java.util.concurrent.ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        Runnable runnableTask = () -> {
            System.out.println("Runnable executed by: " + Thread.currentThread().getName());
        };

        fixedPool.execute(runnableTask); // no return
        fixedPool.submit(runnableTask);  // returns Future<?>

        // 2️⃣ Callable with Future
        Callable<Integer> callableTask = () -> {
            Thread.sleep(1000);
            return 10 + 20;
        };

        Future<Integer> future = fixedPool.submit(callableTask);
        System.out.println("Callable Result: " + future.get()); // blocks

        // 3️⃣ Cached Thread Pool
        java.util.concurrent.ExecutorService cachedPool = Executors.newCachedThreadPool();
        cachedPool.submit(() ->
                System.out.println("Cached pool thread: " + Thread.currentThread().getName())
        );

        // 4️⃣ Single Thread Executor
        java.util.concurrent.ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        singleExecutor.submit(() ->
                System.out.println("Single thread executor")
        );

        // 5️⃣ Scheduled Executor
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(1);

        scheduler.schedule(() ->
                        System.out.println("Delayed task executed"),
                2,
                TimeUnit.SECONDS
        );

        // 6️⃣ Graceful Shutdown
        fixedPool.shutdown();
        cachedPool.shutdown();
        singleExecutor.shutdown();
        scheduler.shutdown();
    }


}

