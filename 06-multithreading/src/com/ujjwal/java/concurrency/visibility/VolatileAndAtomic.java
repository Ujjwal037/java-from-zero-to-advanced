package com.ujjwal.java.concurrency.visibility;

import java.util.concurrent.atomic.AtomicInteger;

class VolatileAndAtomic {

    // 1️⃣ Visibility problem (non-volatile)
    static boolean running = true;

    // 2️⃣ Visibility fix using volatile
    static volatile boolean volatileRunning = true;

    // 3️⃣ Atomicity problem with volatile
    static volatile int volatileCounter = 0;

    // 4️⃣ Atomic solution
    static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        // ---------------- VISIBILITY PROBLEM ----------------
        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started (non-volatile flag)");
            while (running) {
                // may never stop due to cache visibility
            }
            System.out.println("Thread-1 stopped");
        });

        t1.start();
        Thread.sleep(1000);
        running = false; // may NOT be visible
        Thread.sleep(1000);

        System.out.println("------------------------------------------------");

        // ---------------- VISIBILITY FIX ----------------
        Thread t2 = new Thread(() -> {
            System.out.println("Thread-2 started (volatile flag)");
            while (volatileRunning) {
                // guaranteed visibility
            }
            System.out.println("Thread-2 stopped");
        });

        t2.start();
        Thread.sleep(1000);
        volatileRunning = false; // visible immediately
        t2.join(); // happens-before guarantee

        System.out.println("------------------------------------------------");

        // ---------------- ATOMICITY PROBLEM ----------------
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                volatileCounter++; // NOT atomic
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                volatileCounter++;
            }
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Volatile Counter (Expected 2000): " + volatileCounter);

        System.out.println("------------------------------------------------");

        // ---------------- ATOMIC SOLUTION ----------------
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });

        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet();
            }
        });

        t5.start();
        t6.start();

        t5.join();
        t6.join();

        System.out.println("Atomic Counter: " + atomicCounter.get());
    }
//    ✔ CPU Cache & Visibility
//
//running may never update
//
//JVM caches value per thread
//
//✔ volatile
//
//Forces main memory read/write
//
//Fixes infinite loop
//
//✔ Visibility ≠ Atomicity
//
//volatileCounter++ breaks
//
//Compound operation ≠ atomic
//
//✔ AtomicInteger
//
//CAS-based lock-free atomicity
//
//Correct final result
//
//✔ Happens-Before
//
//volatile write → read
//
//join() ensures visibility
}
