package com.ujjwal.java.designpattern.Creational;

public class SingletonBestApproach {
//    BEST Singleton (Industry Standard)

    static class Singleton {
        private Singleton() {}

        private static class Holder {
            private static final Singleton INSTANCE = new Singleton();
        }

        public static Singleton getInstance() {
            return Holder.INSTANCE;
        }
    }
}
