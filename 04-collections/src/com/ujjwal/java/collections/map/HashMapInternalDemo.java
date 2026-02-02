package com.ujjwal.java.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternalDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("Java", 1);
        map.put("Spring", 2);
        map.put("Hibernate", 3);
        map.put("Java", 10); // replaces value

        System.out.println(map.get("Java"));
        System.out.println(map);
    }
}

