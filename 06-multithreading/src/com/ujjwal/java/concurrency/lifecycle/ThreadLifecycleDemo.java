package com.ujjwal.java.concurrency.lifecycle;

public class ThreadLifecycleDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {

            try {
                System.out.println("Worker started");
                Thread.sleep(2000); // TIMED_WAITING
                System.out.println("Worker finished");
            } catch (InterruptedException e) {
                System.out.println("Worker interrupted");
            }

        });

        System.out.println("State before start: " + worker.getState());

        worker.start();
        System.out.println("State after start: " + worker.getState());

        Thread.sleep(500);
        System.out.println("State while sleeping: " + worker.getState());

        worker.join(); // WAITING
        System.out.println("State after completion: " + worker.getState());
    }
}
