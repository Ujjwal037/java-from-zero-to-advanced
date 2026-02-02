package com.ujjwal.java.collections.Concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>();

        map.put("A", 1);
        map.put("B", 2);

        map.forEach((k, v) -> {
            map.put("C", 3); // No exception
            System.out.println(k + " = " + v);
        });

        System.out.println(map);
    }
}

