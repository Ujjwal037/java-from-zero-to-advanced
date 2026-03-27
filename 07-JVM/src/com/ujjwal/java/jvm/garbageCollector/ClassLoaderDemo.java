package com.ujjwal.java.jvm.garbageCollector;

public class ClassLoaderDemo {

    public static void main(String[] args) {

        ClassLoader appLoader =
                ClassLoaderDemo.class.getClassLoader();

        System.out.println("Application Loader: " + appLoader);

        System.out.println("Parent Loader: " +
                appLoader.getParent());

        System.out.println("Bootstrap Loader: " +
                appLoader.getParent().getParent());
    }
}
