package com.ujjwal.java.jvm.basics;

public class JVMMemoryManagement {

    static class Singleton {

        private static volatile Singleton instance;

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
//Final Field Semantics
//
//Final fields have special guarantees.
//
//        Example:

    class Person {
        final int age;

        Person(int age) {
            this.age = age;
        }
    }
}

//Why JVM Memory Model Exists
    //Modern CPUs:Have multiple cores
    //Use CPU caches (L1, L2, L3)
    //Reorder instructions
    //Use store buffers
    //If Java did not define strict memory rules:
    //Thread A writes x = 10
    //Thread B reads x
    //There would be no guarantee B sees 10.
    //The Java Memory Model (JMM) defines: When writes by one thread become visible to another.
//Final Field Semantics
    //Final fields have special guarantees.
    //Example:
    //
    //class Person {
    //    final int age;
    //
    //    Person(int age) {
    //        this.age = age;
    //    }
    //}
    //After constructor finishes,
    //other threads will always see correct final values.
    //Even without synchronization.
    //This prevents partially constructed objects.
    //
//Interview-Level Questions
    //❓ Why can reordering happen in Java?
    //
    //Because:
    //
    //Compiler optimization
    //
    //CPU out-of-order execution
    //
    //As long as single-thread semantics preserved
//❓ Why is volatile needed for double-checked locking?
    //
    //Without volatile:
    //
    //Object reference assigned before constructor completes
    //
    //Other thread sees partially constructed object
//❓ Does synchronized prevent reordering? Yes.
    //Entering and exiting monitor introduces memory barriers.
    //
    //🧪 Mental Model
    //
    //Think of JMM as: Contract between:Java Code, JVM, CPU, Hardware
    //It ensures predictable behavior in concurrent systems.
