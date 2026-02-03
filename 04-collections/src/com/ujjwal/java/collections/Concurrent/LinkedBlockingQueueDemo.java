package com.ujjwal.java.collections.Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        queue.put("A");
        queue.put("B");

        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}

