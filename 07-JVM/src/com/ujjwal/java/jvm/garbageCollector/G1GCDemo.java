package com.ujjwal.java.jvm.garbageCollector;

import java.util.ArrayList;
import java.util.List;

public class G1GCDemo {

    public static void main(String[] args) {

        List<byte[]> data = new ArrayList<>();

        for (int i = 0; i < 2000; i++) {
            data.add(new byte[1024 * 1024]); // 1MB
            if (i % 100 == 0) {
                System.out.println("Allocated: " + i + " MB");
            }
        }

        System.out.println("Finished allocations");
    }
}

//Why G1 GC Was Introduced
    //Older collectors like:Serial,Parallel,CMS (Concurrent Mark Sweep)
    //
    //Had problems: Long pause times, Fragmentation (CMS), Poor large heap handling
    //
    //So Oracle introduced: Garbage-First Garbage Collector (G1 GC)
    //Goal: Predictable pause times, Large heap support (multi-GB), Better throughput + latency balance
    //Default since Java 9.
//
//G1 GC Phases :
    //
    //G1 operates in cycles:
    //1️⃣ Young GC (Evacuation Pause): Stop-the-world, Collect Eden + Survivor, Promote survivors, Fast & frequent.
    //2️⃣ Concurrent Marking Phase: Runs alongside application: Initial mark (STW), Root region scan ,Concurrent mark ,Remark (STW), Cleanup
    //Purpose:Identify live objects in old gen
    //3️⃣ Mixed GC : After marking: Collects both Young + selected Old regions , Focuses on regions with most garbage
    //This is why it is called: Garbage-First
    //It collects regions with highest reclaimable space first.
    //🔥 Humongous Objects
        //Objects > 50% of region size:
        //
        //Allocated directly in Old Gen
        //
        //Special handling
        //
        //Can trigger Full GC
        //
        //Example: Large arrays or buffers.
    //⚠️ Stop-The-World (STW) Events
        //G1 still pauses application for:
        //Initial mark
        //Remark
        //Young evacuation
        //But pauses are: Short, Target-based
        //
//When To Use G1?
        //Use G1 if: Heap > 4GB, Latency-sensitive application ,Microservices, Large backend systems
        //Avoid if: Minimal heap, Simple batch processing (Parallel GC better)
