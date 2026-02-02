package com.ujjwal.java.collections.Concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer i : list) {
            list.add(4); // No exception
            System.out.println(i);
        }

        System.out.println(list);
    }
}

