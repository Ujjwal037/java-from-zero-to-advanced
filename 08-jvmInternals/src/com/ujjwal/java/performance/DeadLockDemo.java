package com.ujjwal.java.performance;

class DeadlockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                sleep();
                synchronized (lock2) {}
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                sleep();
                synchronized (lock1) {}
            }
        });

        t1.start();
        t2.start();
    }

    static void sleep() {
        try { Thread.sleep(100);
        }
        catch (Exception ignored) {

        }

    }
}

//Thread-1 waiting to lock lock2
//Thread-2 waiting to lock lock1
//Circular dependency → deadlock.

//🔥 Real Production Patterns
    //🔴 Pattern 1: High CPU Issue
        //Look for:
        //Threads in RUNNABLE
        //Same stack repeating
        //Example: while(true) { }
    //🔴 Pattern 2: Thread Pool Exhaustion
        //Threads stuck in:
        //WAITING (on queue) Or: BLOCKED
        //Symptoms: Requests hang
        // No free threads
    //🔴 Pattern 3: Database Slowness
        //Threads stuck at:
        //java.sql.PreparedStatement.execute()
        //Meaning:DB is slow / locked

    //🔴 Pattern 4: Synchronization Bottleneck
        //Many threads:
        //BLOCKED on same object
        //Indicates:Hot lock, Poor design
    //🔥 Advanced Insight: Lock Ownership
        //Thread dump shows:- locked <0x000001>
        //- waiting to lock <0x000002>
        //You can trace:Who owns lock
        //Who is waiting
