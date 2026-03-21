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
