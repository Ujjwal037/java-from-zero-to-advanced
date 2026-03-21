package com.ujjwal.java.performance;

import java.util.ArrayList;
import java.util.List;

public class MemoryPressureApp {

    public static void main(String[] args) throws InterruptedException {

        List<byte[]> list = new ArrayList<>();

        while (true) {
            list.add(new byte[1024 * 1024]); // 1MB
            Thread.sleep(100);
        }
    }
}
//
//| Column | Meaning         |
//| ------ | --------------- |
//| S0/S1  | Survivor spaces |
//| E      | Eden            |
//| O      | Old Gen         |
//| YGC    | Young GC count  |
//| FGC    | Full GC count   |
//| GCT    | Total GC time   |
//
//🔥 How to Interpret
    //Eden high → frequent allocations
    //
    //YGC increasing fast → high allocation rate
    //
    //FGC increasing → problem (bad sign)
//Key Signals to Watch
    //🚨 Memory Issue
        // Old gen steadily increasing
        //
        //FGC happening frequently
    //🚨 CPU Issue
        //High thread count
        //
        //Thread dump shows BLOCKED threads
    //🚨 GC Issue
        //Long pause time
        //
        //High GCT

