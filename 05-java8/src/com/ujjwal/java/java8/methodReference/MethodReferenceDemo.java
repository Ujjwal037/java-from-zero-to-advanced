package com.ujjwal.java.java8.methodReference;

import java.util.*;
import java.util.function.*;

public class MethodReferenceDemo {

    public static void main(String[] args) {

        /* =========================================
           1. Static Method Reference
           ========================================= */

        Function<Integer, String> lambdaToString =
                String::valueOf;

        Function<Integer, String> methodRefToString =
                String::valueOf;

        System.out.println("Static Method Reference:");
        System.out.println(methodRefToString.apply(100));


        /* =========================================
           2. Instance Method Reference (Object)
           ========================================= */

        MethodReferenceDemo demo = new MethodReferenceDemo();

        Predicate<String> lambdaCheck =
                demo::isLongString;

        Predicate<String> methodRefCheck =
                demo::isLongString;

        System.out.println("\nInstance Method Reference:");
        System.out.println(methodRefCheck.test("Java"));
        System.out.println(methodRefCheck.test("JavaProgramming"));


        /* =========================================
           3. Instance Method Reference (Class)
           ========================================= */

        BiPredicate<String, String> lambdaEquals =
                String::equals;

        BiPredicate<String, String> methodRefEquals =
                String::equals;

        System.out.println("\nInstance Method Reference (Class):");
        System.out.println(methodRefEquals.test("Java", "Java"));


        /* =========================================
           4. Constructor Method Reference
           ========================================= */

        Supplier<List<String>> lambdaList =
                ArrayList::new;

        Supplier<List<String>> methodRefList =
                ArrayList::new;

        System.out.println("\nConstructor Method Reference:");
        List<String> list = methodRefList.get();
        list.add("Java");
        list.add("Spring");
        System.out.println(list);


        /* =========================================
           5. Method Reference with Streams
           ========================================= */

        List<String> names = Arrays.asList("ujjwal", "aman", "raj");

        System.out.println("\nMethod Reference with Streams:");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        /* =========================================
           6. Comparator using Method Reference
           ========================================= */

        List<Integer> numbers = Arrays.asList(30, 10, 20);

        numbers.sort(Integer::compareTo);

        System.out.println("\nSorted Numbers:");
        numbers.forEach(System.out::println);
    }

    /* Helper method */
    public boolean isLongString(String str) {
        return str.length() > 5;
    }
}

