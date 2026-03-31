package com.ujjwal.java.IO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.util.concurrent.Future;

public class AsyncFileRead {
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("data.txt");

        AsynchronousFileChannel channel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Future<Integer> result = channel.read(buffer, 0);

        while (!result.isDone()) {
            System.out.println("Reading asynchronously...");
        }

        buffer.flip();
        System.out.println(new String(buffer.array()));

        channel.close();

//      Callback-Based (Better Approach)
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            public void completed(Integer result, ByteBuffer buffer) {
                System.out.println("Read complete");
            }

            public void failed(Throwable exc, ByteBuffer buffer) {
                System.out.println("Read failed");
            }
        });
    }
}

//1. Evolution of IO Models (Context First)
    //Blocking IO  →  NIO (Non-blocking)  →  AIO (Async)
    //Model	Behavior
    //Blocking	Thread waits
    //Non-blocking	Polling with Selector
    //Async (AIO)	OS notifies completion
//2. Asynchronous IO (AIO)
    //Java introduced AsynchronousChannel for async operations.
    //You don't wait → You get notified when operation completes
