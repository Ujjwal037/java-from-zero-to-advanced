package com.ujjwal.java.designpattern.Creational;




public class Singleton {

    //Basic Singleton (Not Thread Safe)
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


}

