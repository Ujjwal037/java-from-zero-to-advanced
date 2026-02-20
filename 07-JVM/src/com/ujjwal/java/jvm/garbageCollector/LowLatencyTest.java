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
