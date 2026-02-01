package com.ujjwal.java.collections.overview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionsOverviewDemo {

    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        collection.add("Java");
        collection.add("Python");

        List<String> list = new ArrayList<>();
        list.add("Spring");
        list.add("Hibernate");

        System.out.println(collection);
        System.out.println(list);
    }
}

