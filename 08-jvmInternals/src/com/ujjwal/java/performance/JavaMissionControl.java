package com.ujjwal.java.performance;

public class JavaMissionControl {

//Java Mission Control is:
//Official JVM analysis tool
//GUI for analyzing JFR recordings
//Real-time monitoring + post-analysis
//Think of it as:“Control center for JVM observability”
//🔧 1️⃣ How to Use JMC
//    Step 1: Open JMC > Download or use bundled version (JDK dependent).
//    Step 2: Open JFR File > File → Open → recording.jfr
//    Step 3: Navigate Sections
//    Main tabs:Overview > Threads > Memory> GC > CPU > I/O > Locks
//🧠 2️⃣ Overview Tab (Start Here)
//    This gives:CPU usage graph > Heap usage > GC pauses > Thread activity
//    🔍 What to Look For
//    CPU spikes
//    Memory growth
//    GC pause spikes
//    Thread count surge
//🔥 3️⃣ CPU Analysis (Hot Methods)
//    Flame Graph
//    Visualizes:Which methods consume most CPU
        //    Interpretation
        //    Wide blocks → more CPU usage
        //    Deep stacks → nested calls
        //    Example Insight
        //    processData() → 60% CPU
//      👉 Optimize that method.
//🧠 4️⃣ Memory Analysis
//    Allocation Profiling
//Shows:Which classes allocate most memory
//      Allocation rate
//      Example
//      byte[] → 70% allocation
//👉 Possible buffer misuse.
//Key Insight
//High allocation rate = frequent GC.
//5️⃣ GC Analysis
//    Metrics to Watch
//    GC pause time
//    Frequency
//    Heap usage before/after
//    Example
//    Pause: 200ms
//    Frequency: high
//
//👉 GC tuning required.
//Visual Graph
//You’ll see:Heap curve,GC spikes
//6️⃣ Thread Analysis
//    Thread States
//    RUNNABLE
//    BLOCKED
//    WAITING
//    What to Look For
//    Many BLOCKED threads → contention
//    Many WAITING → idle / queue wait
//    High RUNNABLE → CPU pressure
//7️⃣ Lock Contention Analysis
//    Shows:
//    Which locks are contended
//    Which threads are blocked
//    Example
//    Lock: UserService.process()
//    Threads blocked: 50
//👉 Synchronization bottleneck.
//8️⃣ I/O Analysis
//Shows:File I/O
//      Network I/O
//      Blocking operations
//      Example
//      Socket read → high latency
//      External system issue.
//Correlation (Most Powerful Feature)
//MC allows:Correlating events across time
//Example:CPU spike → GC pause → thread blocking
//        You see cause → effect chain.
//Real Debugging Example
//    Scenario: Slow API
//    Step 1: Open JFR in JMC
//    Step 2: Check CPU
//
//👉 Hot method found:
//
//    calculateReport()
//    Step 3: Check Memory
//
//👉 High allocation:
//
//    List creation inside loop
//    Step 4: Check GC
//
//👉 Frequent minor GC
//
//    Root Cause:
//    Inefficient object creation inside loop
//    Fix: Reuse objects
//    Optimize data structure
//    Advanced Feature: Automated Analysis
//JMC provides:“Automated Analysis Results”
// Shows:Memory issues
//       GC issues
//       Thread contention
//       Use it as first-pass diagnosis.
//
// 🔥 Common Patterns You Must Recognize
        //🔴 Pattern 1: CPU Bottleneck
        //    One method dominating CPU
        //    Deep call stack
        //🔴 Pattern 2: Allocation Pressure
        //    High object creation
        //    Frequent GC
        //🔴 Pattern 3: Lock Contention
        //    Many threads BLOCKED
        //    Same lock
        //🔴 Pattern 4: GC Problem
        //    Long pauses
        //    Heap not reducing
//
//
}
