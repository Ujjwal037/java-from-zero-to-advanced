package com.ujjwal.java.concurrency.synchronization;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Working...");
                    Thread.sleep(1000); // interruptible
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted safely");
            }
        });

        worker.start();

        Thread.sleep(3000);
        worker.interrupt(); // signal termination
    }
}
