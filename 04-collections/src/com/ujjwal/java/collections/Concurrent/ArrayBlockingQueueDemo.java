package com.ujjwal.java.collections.Concurrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);

        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}

