package com.ujjwal.java.collections.Set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {

    public static void main(String[] args) {

        NavigableSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println(set.lower(20));   // 10
        System.out.println(set.floor(20));   // 20
        System.out.println(set.ceiling(25)); // 30
        System.out.println(set.higher(20));  // 30
    }
}

