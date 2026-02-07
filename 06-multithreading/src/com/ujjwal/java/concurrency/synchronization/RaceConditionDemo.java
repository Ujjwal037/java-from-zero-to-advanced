package com.ujjwal.java.concurrency.synchronization;

class Counter {
    int count = 0;

    void increment() {
        count++; // NOT ATOMIC
    }
}

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                Thread.yield(); // hint scheduler to switch thread
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count (Expected 2000): " + counter.count);
    }
}

