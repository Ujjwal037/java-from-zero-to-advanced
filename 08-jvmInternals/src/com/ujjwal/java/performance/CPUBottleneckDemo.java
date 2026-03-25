package com.ujjwal.java.performance;


public class CPUBottleneckDemo {

    public static void main(String[] args) {
        while (true) {
            heavyTask();
        }
    }
    static void heavyTask() {
        for (int i = 0; i < 100000; i++) {
            Math.sqrt(i);
        }
    }
}

//What Is CPU Profiling?
//CPU profiling identifies:Which methods consume CPU time
//Where threads spend execution time
//Whether bottleneck is CPU, lock, or I/O
//🧠 Types of CPU Issues
    //🔴 1. CPU-Bound
            //Heavy computation
            //Tight loops
            //Inefficient algorithms
    //🔴 2. Lock Contention
            //Threads waiting for locks
            //CPU underutilized but app slow
    //🔴 3. I/O Bound
            //Waiting on DB / network
            //CPU low but latency high
//1️⃣ Tools for CPU Profiling
    //🛠 Primary Tools
    //Java Flight Recorder (JFR) → low overhead
    //Java Mission Control (JMC) → visualization
    //jstack → thread-level insight
    //OS tools (top, htop)
//2️⃣ Profiling Approach (Real Workflow)
    //Step 1: Check CPU Usage
    //top -p <pid>
    //Step 2: Capture JFR
    //jcmd <pid> JFR.start duration=60s filename=cpu.jfr
    //Step 3: Analyze in JMC
    //Check:Hot methods
            //Flame graph
            //Thread usage
    //Step 4: Correlate
            //CPU + Threads + GC
//3️⃣ Flame Graph (Most Important Tool)
    //What It Shows
    //Stack trace + CPU usage
    //How to Read
    //        Width = CPU time
    //        Depth = call stack
    //        Example
    //processData() → 70% CPU
    //   → parse()
    //   → validate()
    //
    //👉 Root cause: processData()
//4️⃣ Thread-Level CPU Analysis
    //Using jstack
    //jstack <pid>
    //Look for:
    //RUNNABLE threads with same stack
    //
    //Example:at CPUBottleneckDemo.heavyTask()
    //👉 CPU hotspot identified.
//5️⃣ Lock Contention vs CPU
    //🔴 Lock Contention
    //Symptoms:Many BLOCKED threads
                //CPU not fully used
                //Thread dump:
                //BLOCKED on synchronized
    //🔴 CPU Bound
    //Symptoms:Threads RUNNABLE
               //CPU near 100%
    //🔴 I/O Bound
    //Symptoms:Threads WAITING
                //CPU low
//6️⃣ Common CPU Bottleneck Patterns
//🔴 Pattern 1: Inefficient Loop
//        for (...) {
//        list.contains(x); // O(n)
//        }
// Convert to: Set → O(1)
//🔴 Pattern 2: Excessive Object Creation
                //new Object() inside loop
                //Causes:CPU + GC pressure
//🔴 Pattern 3: String Concatenation
            //String s = "";
            //for (...) {
            //s += i;
            //}
            //Use:StringBuilder
//🔴 Pattern 4: Synchronization Overuse
//synchronized method
// Leads to:Blocking
          //Throughput drop
//🔴 Pattern 5: Busy Waiting
                //while (!flag) { }
//👉 Replace with:wait/notify
                //Lock/Condition
//🔥 7️⃣ Optimization Techniques
//✅ Algorithm Optimization
//Reduce time complexity
//Use proper data structures
//✅ Reduce Lock Contention
//Use ConcurrentHashMap
//Use fine-grained locks
//✅ Avoid Unnecessary Work
//Cache results
//Avoid recomputation
//✅ Use Parallelism Carefully
//Thread pools
//ForkJoinPool
//✅ Batch Processing
//Reduce repeated operations