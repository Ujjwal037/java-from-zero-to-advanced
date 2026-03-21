package com.ujjwal.java.performance;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {

    static List<byte[]> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            list.add(new byte[1024 * 1024]); // 1MB
            Thread.sleep(100);
        }
    }
}


//🎯 What Is a Heap Dump?
    //A heap dump is a snapshot of:
    //All objects in memory
    //Their references
    //Memory usage (heap)
    //Object relationships
    //It answers:“What is occupying memory and why is it not getting garbage collected?”
//What Happens?
    //Memory keeps increasing
    //GC runs but cannot free memory
    //Eventually → OutOfMemoryError

//🧠 Key Concepts You MUST Understand
//1️⃣ Shallow Size vs Retained Size
        //Shallow Size
        //Memory consumed by the object itself.
        //
        //Example: new User();  // object size only
        //Retained Size (VERY IMPORTANT)
        //Total memory retained if this object is removed.
        //Includes:Object itself
        //All objects reachable from it
        //This is how you find memory leaks.
//2️⃣ GC Roots
        //Garbage Collector starts from: GC Roots
        //Examples:Static variables
        //Thread stack references
        //Active threads
        //JNI references
        //Rule:If an object is reachable from GC Roots → NOT garbage collected
        //🔥 Memory Leak Definition (JVM)
        //Object is no longer needed but still reachable from GC Roots
//3️⃣ Dominator Tree (Most Important Tool)
        //Shows:Which object is retaining the most memory
        //Example : CacheManager → Map → 1M objects
        //If CacheManager is root: 👉 It dominates all those objects.
//🔍 Heap Dump Analysis Workflow
        //Step 1: Open in Analyzer Tool
        //Use:Eclipse MAT
        //Step 2: Check “Leak Suspects”
        //Tool auto-detects:
        //Large retained objects
        //Suspicious patterns
        //Step 3: Sort by Retained Size
        //Find:Top memory consumers
        //Step 4: Analyze Dominator Tree
        //Trace:Who is holding memory?
        //Step 5: Trace GC Roots
        //Check:Why object is not getting collected?
//🔥 Common Memory Leak Patterns
        //🔴 1. Static Collections
            //static List<Object> list = new ArrayList<>();
            //Never cleared → permanent memory growth.
        //🔴 2. Cache Without Eviction
            //Map<String, Data> cache = new HashMap<>();
            //No limit → memory explosion.
        //🔴 3. ThreadLocal Leak
            //ThreadLocal<MyObject> tl = new ThreadLocal<>();
            //If not removed:Thread → ThreadLocalMap → Object stays forever
        //🔴 4. Listener / Callback Leak
            //Objects registered but never removed.
        //🔴 5. ClassLoader Leak
            //Common in:Tomcat
            //Spring DevTools
            //Old classloader retained → entire app not GC’d.