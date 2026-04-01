package com.ujjwal.java.designpattern.Creational;

//Thread-Safe Singleton (Synchronized)

public class SingletonSynchronized {
    static class Singleton {
        private static Singleton instance;

        private Singleton() {}

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
