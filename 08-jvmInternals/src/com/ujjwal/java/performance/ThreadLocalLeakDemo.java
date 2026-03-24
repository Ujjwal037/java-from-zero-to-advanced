package com.ujjwal.java.performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalLeakDemo {
    static ThreadLocal<byte[]> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
            for (int i = 0; i < 1000; i++) {
            pool.submit(() -> {
                tl.set(new byte[1024 * 1024]); // 1MB
            });
        }
    }
}

//What Is a Memory Leak (JVM Context)?
//
//Object is no longer needed but still reachable from GC Roots
//
//So GC cannot reclaim it.
//
//🧠 Key Insight
    //Garbage Collector only removes:
    //UNREACHABLE objects
    //If reference exists → NOT GC’d, even if useless.
//1️⃣ Types of Memory Leaks
//🔴 1. Heap Memory Leak
//Objects retained in heap
//Seen in heap dump
//Example:List<Object> list = new ArrayList<>(); list.add(new Object()); // never removed
//🔴 2. Metaspace Leak (ClassLoader Leak)
//Classes not unloaded
//Common in servers
//Symptoms:OutOfMemoryError: Metaspace
//🔴 3. Native Memory Leak
//Outside JVM heap
//DirectByteBuffer, JNI
//Harder to detect.
//2️⃣ Most Common Leak Patterns (Must Master)
//🔴 Pattern 1: Static Collection Leak
//class Cache {
//    static List<Object> data = new ArrayList<>();
//}
//Problem:Static = GC Root, Data never released
//🔴 Pattern 2: Unbounded Cache
//Map<String, Object> cache = new HashMap<>();
//No eviction policy → infinite growth.
//🔴 Pattern 3: ThreadLocal Leak (VERY COMMON)
//ThreadLocal<User> tl = new ThreadLocal<>();
//tl.set(new User());
//If not removed:Thread → ThreadLocalMap → User (leaked)
//Especially dangerous in thread pools.
//Fix:try {
//        tl.set(user);
// } finally {
//        tl.remove();
//}
//🔴 Pattern 4: Listener / Callback Leak
//publisher.register(listener);
//If never removed:
//Listener stays forever
//Prevents GC
//🔴 Pattern 5: Inner Class Holding Outer Reference
    //class Outer {
    //    class Inner { }
    //}
//Inner class implicitly holds outer reference.
//🔴 Pattern 6: ClassLoader Leak
//Common in:App servers, Hot reload
//Cause:Static references , Threads not stopped
//🔴 Pattern 7: Direct ByteBuffer Leak
//ByteBuffer.allocateDirect(1024);
//Uses native memory.
//GC does NOT immediately reclaim.
//3️⃣ Detection Strategy (Step-by-Step)
//Step 1: Identify Symptoms
//Memory keeps increasing
//GC frequent but ineffective
//Eventually OOM
//Step 2: Monitor with jstat
//jstat -gc <pid> 1000
//Look for:Old gen increasing
//FGC not freeing memory
//Step 3: Take Heap Dump
//jcmd <pid> GC.heap_dump heap.hprof
//Step 4: Analyze (Dominator Tree)
//Look for:Top retained objects
//Step 5: Trace GC Root Path
//Why object is retained?

//5️⃣ Real Example — Cache Leak
//Bad Design
//Map<String, Object> cache = new HashMap<>();
//Fix Options
//Option 1: LRU Cache
//LinkedHashMap with removeEldestEntry()
//Option 2: Use library
//Caffeine (recommended)
//Guava Cache
//6️⃣ ClassLoader Leak (Advanced)
//Scenario
//App redeployed
//Old ClassLoader should die
//But:Static reference → prevents GC
//Example Cause
//Thread not stopped
//Timer still running
//Static singleton
//Result
//Multiple ClassLoaders in memory
//→ Metaspace OOM
//7️⃣ Native Memory Leak Detection
//Use:jcmd <pid> VM.native_memory summary
//Look for:Direct buffer usage
//Thread stack memory
//🧠 8️⃣ Prevention Strategy (Engineering Best Practices)
//✅ Always clear ThreadLocal
//finally {
//remove();
//}
//✅ Use bounded caches
//Never unbounded.
//✅ Avoid unnecessary static references
//✅ Proper lifecycle management
//Close resources
//Stop threads
//✅ Monitor continuously
//Use:JFR, JMC, Metrics
//9️⃣ Production Debug Checklist
//When memory issue occurs:
//✔ Check heap usage trend
//✔ Check GC logs
//✔ Take heap dump
//✔ Analyze retained size
//✔ Find GC root
//✔ Fix reference
//🧠 Interview Questions
//❓ Why ThreadLocal causes leaks?
//Because thread lives longer than data.
//❓ Why static variables are dangerous?
//They are GC roots.
//❓ Difference between heap leak and metaspace leak?
//Heap	Metaspace
//Objects	Classes
//jmap	ClassLoader analysis
//❓ How to confirm memory leak?
//Heap usage grows
//GC cannot reclaim
//Heap dump shows retained objects