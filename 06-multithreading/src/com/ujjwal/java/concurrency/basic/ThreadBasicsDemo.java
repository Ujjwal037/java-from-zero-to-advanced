package com.ujjwal.java.concurrency.basic;

public class ThreadBasicsDemo {

    public static void main(String[] args) {

        System.out.println("Main thread started: "
                + Thread.currentThread().getName());

        /* ===============================
           1. Creating thread using Thread class
           =============================== */

        MyThread thread1 = new MyThread();
        thread1.start(); // creates new thread


        /* ===============================
           2. Creating thread using Runnable
           =============================== */

        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();


        /* ===============================
           3. Lambda Runnable (Java 8)
           =============================== */

        Thread thread3 = new Thread(() ->
                System.out.println("Lambda Thread running: "
                        + Thread.currentThread().getName())
        );
        thread3.start();

        System.out.println("Main thread ended");
    }
}

/* ===============================
   Thread class approach
   =============================== */

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread running: "
                + Thread.currentThread().getName());
    }
}

/* ===============================
   Runnable interface approach
   =============================== */

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable running: "
                + Thread.currentThread().getName());
    }
}

