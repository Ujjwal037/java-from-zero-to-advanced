package com.ujjwal.java.concurrency.communication;

class SharedBuffer {

    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait until data is consumed
        }

        data = value;
        hasData = true;
        System.out.println("Produced: " + value);

        notify(); // notify consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait until data is produced
        }

        hasData = false;
        System.out.println("Consumed: " + data);

        notify(); // notify producer
        return data;
    }
}

