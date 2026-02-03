package com.ujjwal.java.collections.Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        queue.put(40);
        queue.put(10);
        queue.put(30);

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}

