package com.ujjwal.java.collections.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(40);
        pq.add(10);
        pq.add(30);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

