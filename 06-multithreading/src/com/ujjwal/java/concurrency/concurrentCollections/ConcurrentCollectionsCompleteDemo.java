package com.ujjwal.java.concurrency.concurrentCollections;

import java.util.concurrent.*;

public class ConcurrentCollectionsCompleteDemo {

    public static void main(String[] args) throws Exception {

        // 1️⃣ ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        Runnable mapTask = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put(Thread.currentThread().getName() + i, i);
            }
        };

        Thread t1 = new Thread(mapTask);
        Thread t2 = new Thread(mapTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("ConcurrentHashMap size: " + map.size());

        System.out.println("------------------------------------------------");

        // 2️⃣ CopyOnWriteArrayList
        CopyOnWriteArrayList<String> cowList =
                new CopyOnWriteArrayList<>();

        cowList.add("A");
        cowList.add("B");

        for (String s : cowList) {
            cowList.add("C"); // Safe modification during iteration
            break;
        }

        System.out.println("CopyOnWriteArrayList: " + cowList);

        System.out.println("------------------------------------------------");

        // 3️⃣ ConcurrentLinkedQueue (Lock-Free)
        ConcurrentLinkedQueue<Integer> queue =
                new ConcurrentLinkedQueue<>();

        queue.add(10);
        queue.add(20);

        System.out.println("Queue poll: " + queue.poll());

        System.out.println("------------------------------------------------");

        // 4️⃣ BlockingQueue (Producer-Consumer)
        BlockingQueue<Integer> blockingQueue =
                new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                blockingQueue.put(100);
                System.out.println("Produced 100");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumed: " +
                        blockingQueue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("------------------------------------------------");

        // 5️⃣ ConcurrentSkipListMap (Sorted + Concurrent)
        ConcurrentSkipListMap<Integer, String> sortedMap =
                new ConcurrentSkipListMap<>();

        sortedMap.put(3, "C");
        sortedMap.put(1, "A");
        sortedMap.put(2, "B");

        System.out.println("ConcurrentSkipListMap: " + sortedMap);
    }
// Internal Understanding (Interview Level)
//1️⃣ ConcurrentHashMap
//    Java 8 Internal Design:
//
//    No full map locking
//
//    Bucket-level locking
//
//    Uses CAS
//
//    Tree bins when collisions increase
//
//    Better scalability than: Collections.synchronizedMap()
//
//2️⃣ CopyOnWriteArrayList
//
//    When modified:
//
//    Creates new copy of array
//
//    Readers unaffected
//
//    No locking during iteration
//
//✔ Excellent for read-heavy systems
//❌ Bad for write-heavy systems
//
//    Used in: Event listeners ,Subscriber lists
//
//3️⃣ ConcurrentLinkedQueue
//
//    Lock-free
//
//    CAS-based
//
//    Non-blocking
//
//    FIFO
//
//    Used in:Task pipelines,Async message passing
//
//4️⃣ BlockingQueue
//
//    Supports put() and take()
//
//    Blocks when full/empty
//
//    Used in producer-consumer
//
//    Backbone of:
//
//    ThreadPoolExecutor
//
//5️⃣ ConcurrentSkipListMap
//
//    Sorted
//
//    Log(n) performance
//
//    Non-blocking
//
//    Uses skip-list algorithm
//
//🔥 ConcurrentHashMap vs HashMap
//    Feature	HashMap	ConcurrentHashMap
//    Thread safe	❌	✔
//    Null key/value	✔	❌
//    Locking	None	Fine-grained
//    Scalability	Low	High

// Real Backend Architecture
//
//    Production systems use:
//
//    ThreadPoolExecutor
//
//    BlockingQueue
//
//    ConcurrentHashMap (cache)
//
//    CopyOnWriteArrayList (listeners)
//
//    CompletableFuture pipelines
//
//    Rarely: Manual synchronized
}
