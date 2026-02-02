package com.ujjwal.java.collections.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListInternalDemo {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.add(1, 15);

        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        System.out.println("Element at index 1: " + list.get(1));
    }
}
