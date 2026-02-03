package com.ujjwal.java.collections.Set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

    public static void main(String[] args) {

        Set<String> langs = new LinkedHashSet<>();

        langs.add("Java");
        langs.add("Python");
        langs.add("Go");

        System.out.println(langs);
    }
}

