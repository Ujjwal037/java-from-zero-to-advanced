package com.ujjwal.java.collections.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {

    public static void main(String[] args) {

        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(10);
        dq.push(20);
        dq.push(30);

        System.out.println(dq.pop());
    }
}

