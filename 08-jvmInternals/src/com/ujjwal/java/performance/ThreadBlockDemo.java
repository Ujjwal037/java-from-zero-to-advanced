package com.ujjwal.java.performance;

public class ThreadBlockDemo {

    private static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ignored) {}
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}

//Run → Take thread dump → Observe:1 thread RUNNING Others BLOCKED