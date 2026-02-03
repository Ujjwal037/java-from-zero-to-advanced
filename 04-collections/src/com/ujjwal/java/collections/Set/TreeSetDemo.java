package com.ujjwal.java.collections.Set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {

        Set<Integer> nums = new TreeSet<>();

        nums.add(50);
        nums.add(10);
        nums.add(30);
        nums.add(30); // will be removed as duplicated is not allowed in treeSet
        nums.add(75);

        System.out.println(nums);
    }
}

