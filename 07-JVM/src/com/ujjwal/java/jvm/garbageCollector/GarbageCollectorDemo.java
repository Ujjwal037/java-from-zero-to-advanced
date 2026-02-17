package com.ujjwal.java.jvm.garbageCollector;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectorDemo {

    public static void main(String[] args) throws InterruptedException {

        List<byte[]> memoryHog = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            memoryHog.add(new byte[1024 * 1024]); // 1MB
            Thread.sleep(50);
        }

        System.out.println("Completed allocations");
    }
}
//Why GC Exists
//
//Java uses: Automatic Memory Management
//
//
//Instead of: malloc() / free() (C/C++)
//
//
//Goal: Reduce memory leaks
//
//Avoid dangling pointers
//
//Improve safety
//
// But: GC is NOT free — it impacts performance.
//
//The Heap is divided into:
//
//                    HEAP
//        -----------------------------------
//        |        Young Generation       |
//        |-----------------------------|
//        |  |  Eden   | S0 | S1        | |
//        |  -----------------------------|
//        |        Old Generation         |
//        -----------------------------------
//
//1️⃣ Young Generation
//
//Where new objects are created.
//Contains: Eden
//Survivor 0 (S0)
//Survivor 1 (S1)
//
//Most objects: Die young
//Are collected quickly
//This is called: Weak Generational Hypothesis
//
//2️⃣ Old Generation (Tenured)
//
//Objects that: Survive multiple GC cycles
// Long-lived objects
//Example: Caches
//Static collections
//Singleton instances
//
//🔁 Object Lifecycle
//
//Object created → Eden
// Minor GC runs
// Surviving objects → S0
// Next GC → S1
// After threshold → Promoted to Old Gen
// Eventually → Major GC
//
//Types of GC Events
    //GC Type	Affects	Speed
    //Minor GC	Young Gen	Fast
    //Major GC	Old Gen	Slower
    //Full GC	Entire Heap	Slowest
//⚠️ Important : Minor GC is frequent but fast.
//
// Major/Full GC: Causes application pause (Stop-The-World)
// Can impact latency
//
//GC Roots Include: Local variables in stack
// Static fields
// Active threads
// JNI references
//
//If object is NOT reachable → eligible for GC.

//Core GC Algorithms (Conceptual)
//1️⃣ Mark & Sweep
//
//Steps:
//
//Mark live objects
//
//Sweep dead objects
//
//Problem:
//
//Memory fragmentation
//
//2️⃣ Mark & Compact
//
//Steps:
//
//Mark live
//
//Compact memory
//
//✔ Removes fragmentation
//❌ Expensive
//
//3️⃣ Copying Algorithm (Young Gen)
//
//Copy live objects to survivor space
//
//Very fast
//
//Used in Young Generation
//
// Why Young GC Is Fast
//Because: Most objects die quickly
//
//Few survive Copying small live set is efficient
//
// Real GC Implementations
    //GC	        Description
    //Serial GC	    Single-threaded
    //Parallel GC	Multi-threaded
    //CMS	        Concurrent, low pause
    //G1	        Modern default
    //ZGC	        Ultra-low latency
    //Shenandoah	Low pause