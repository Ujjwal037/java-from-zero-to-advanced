package com.ujjwal.java.jvm.garbageCollector;
import java.util.ArrayList;
import java.util.List;

public class LowLatencyTest {

    public static void main(String[] args) throws InterruptedException {

        List<byte[]> memory = new ArrayList<>();

        while (true) {
            memory.add(new byte[1024 * 512]); // 512KB
            Thread.sleep(10);

            if (memory.size() > 2000) {
                memory.clear();
            }
        }
    }
}

//Why New GC Algorithms Were Needed
    //As systems evolved: Heaps grew to 32GB, 64GB, 256GB+
    //Microservices required <10ms latency
    //Trading systems required <5ms latency
    //Cloud-native apps scaled horizontally
    //Traditional collectors (even G1) still have:
    //Stop-the-world (STW) pauses
    //Pause time proportional to heap size (to some degree)
    //So new collectors were introduced:
    //Z Garbage Collector (ZGC)
    //Shenandoah
    //Goal: Pause times under 10ms, regardless of heap size.
    //ZGC Phases Pause: Mark start (very short)
    //Concurrent marking
    //Pause: Mark end
    //Concurrent relocation, Concurrent remapping
    //Application continues during most of this.
//When To Use ZGC ?
    //Use ZGC if: Heap > 8GB
    //Latency-critical system
    //Real-time APIs
    //Trading systems
    //High-scale cloud services
    //Avoid if: Very small heap (<2GB)
    //Batch processing
//Throughput more important than latency
//⚠️ Trade-offs -Low-latency collectors:
    //Use more CPU
    //Slightly lower throughput
    //Higher memory overhead
    //You are trading:- CPU + memory
    //For: Low pause times
//🧠 Production Insight
    //In large fintech or real-time systems:
    //ZGC often preferred
    //G1 still widely used in enterprise apps
    //Parallel GC still used for batch jobs
    //There is no “best GC”.
//Only: Best GC for your workload.
