package com.ujjwal.java.concurrency.synchronization;

class SafeCounter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}

public class SynchronizedCounterDemo {

    public static void main(String[] args) throws InterruptedException {

        SafeCounter counter = new SafeCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                Thread.yield(); // still safe due to lock
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.count);
    }
}

