package com.ujjwal.java.jvm.basics;

public class JVMMemoryDemo {

    static String staticVar = "Stored in Method Area";

    public static void main(String[] args) {

        int localVar = 10; // stored in stack

        Person person = new Person("Ujjwal"); // object in heap

        person.printName();

        recursiveMethod(1); // to demonstrate stack growth
    }

    static void recursiveMethod(int count) {
        if (count == 5) return;
        recursiveMethod(count + 1);
    }
}

class Person {

    String name; // instance variable → heap

    Person(String name) {
        this.name = name;
    }

    void printName() {
        System.out.println(name);
    }
}

//What is JVM?
//
//JVM = Java Virtual Machine
//
//It:
//
//Loads classes
//
//Allocates memory
//
//Executes bytecode
//
//Manages GC
//
//Provides runtime environment

//What Happens Internally?
    //
    //Class loaded → metadata in Metaspace
    //
    //main() pushed to stack
    //
    //localVar stored in stack frame
    //
    //new Person() → object allocated in heap
    //
    //Stack frame destroyed after method returns
    //
    //Heap object eligible for GC after no reference

//JVM Architecture (High-Level)
// +------------------+
// |  Class Loader    |
// +------------------+
// |  Runtime Data    |
// |  Areas           |
// +------------------+
// |  Execution Engine|
// +------------------+
// |  Native Interface|
// +------------------+
//Runtime Data Areas (Critical)
//1️⃣ Heap
//
//Shared memory
//
//Stores objects
//
//GC works here
//
//2️⃣ Stack (Per Thread)
//
//Method calls
//
//Local variables
//
//Stack frames
//
//3️⃣ Method Area (Metaspace)
//
//Class metadata
//
//Static variables
//
//Constant pool
//
//4️⃣ PC Register
//
//Current instruction pointer
//
//5️⃣ Native Method Stack
//
//JNI calls

