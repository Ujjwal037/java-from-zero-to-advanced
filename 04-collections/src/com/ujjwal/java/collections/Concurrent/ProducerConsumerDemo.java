package com.ujjwal.java.collections.Concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                queue.put(i);
                System.out.println("Produced: " + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    public void run() {
        try {
            while (true) {
                Integer val = queue.take();
                System.out.println("Consumed: " + val);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(3);

        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

