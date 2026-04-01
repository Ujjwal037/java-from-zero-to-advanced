package com.ujjwal.java.designpattern.Creational;


//Best Approach: Double-Checked Locking (IMPORTANT)
//Instruction reordering (JVM optimization issue)

public class SingletonWithVolatile {

    static class Singleton {
        private static volatile Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
