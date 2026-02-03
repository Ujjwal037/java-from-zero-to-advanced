package com.ujjwal.java.collections.Concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Delayed {

    private final long startTime;

    DelayedTask(long delay) {
        this.startTime = System.currentTimeMillis() + delay;
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(
                startTime - System.currentTimeMillis(),
                TimeUnit.MILLISECONDS
        );
    }

    public int compareTo(Delayed o) {
        return Long.compare(
                this.startTime,
                ((DelayedTask) o).startTime
        );
    }

    public String toString() {
        return "Task executed";
    }
}

public class DelayQueueDemo {

    public static void main(String[] args) throws Exception {

        DelayQueue<DelayedTask> queue = new DelayQueue<>();

        queue.put(new DelayedTask(3000));

        System.out.println("Waiting...");
        System.out.println(queue.take());
    }
}

