package com.ujjwal.java.performance;

import java.util.ArrayList;
import java.util.List;

public class JFRDemo {

    public static void main(String[] args) throws InterruptedException {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            list.add(new byte[1024 * 512]); // memory pressure

            if (list.size() > 1000) {
                list.clear();
            }

            Thread.sleep(10);
        }
    }
}


//📊 What You See in JMC
//1️⃣ CPU Profiling
    //Hot methods
    //Execution time
    //Call tree
//2️⃣ Memory Allocation
    //Which class allocates most objects
    //Allocation rate
//3️⃣ GC Analysis
    //Pause time
    //Frequency
    //Heap usage
//4️⃣ Thread Analysis
    //Blocked threads
    //Lock contention
    //🔥 Real Production Use Cases
//🔴 Case 1: High CPU
    //JFR shows:Method consuming CPU
    //Call stack👉 Fix inefficient logic
//🔴 Case 2: Memory Leak
    //JFR shows:Allocation rate
    //Object types
    //👉 Identify leak source
//🔴 Case 3: Slow Response
    //JFR shows:GC pause
    //Thread blocking
    //I/O delay
//👉 Identify bottleneck
    //⚡ JFR vs Traditional Tools
    //Tool	Use
    //jstack	Thread snapshot
    //jmap	Heap snapshot
    //JFR	Continuous event recording
    //JFR = time-based observability