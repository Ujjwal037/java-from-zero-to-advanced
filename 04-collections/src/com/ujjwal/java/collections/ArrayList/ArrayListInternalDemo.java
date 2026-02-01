package com.ujjwal.java.collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListInternalDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            list.add(i);
            System.out.println(
                    "Added: " + i + " | Size: " + list.size()
            );
        }
        System.out.println("Final List: " + list);
    }
}
