package com.ujjwal.java.IO;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedExample {
    public static void main(String[] args) throws Exception {

        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
        FileChannel channel = file.getChannel();

        MappedByteBuffer buffer =
                channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());

        buffer.put(0, (byte) 'H');

        channel.close();
        file.close();
    }
}

//Memory-Mapped Files (MappedByteBuffer)
    //This is extremely powerful.
    //Uses OS memory directly (not JVM heap)
    //Using:MappedByteBuffer

// Why It’s Fast
    //OS handles memory
    //No copying between kernel & user space
    //Direct access