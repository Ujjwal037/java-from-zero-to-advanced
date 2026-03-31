package com.ujjwal.java.IO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ZeroCopyExample {
    public static void main(String[] args) throws Exception {

        RandomAccessFile source = new RandomAccessFile("source.txt", "r");
        RandomAccessFile dest = new RandomAccessFile("dest.txt", "rw");

        FileChannel fromChannel = source.getChannel();
        FileChannel toChannel = dest.getChannel();

        fromChannel.transferTo(0, fromChannel.size(), toChannel);

        fromChannel.close();
        toChannel.close();

        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] buffers = {header, body};

        toChannel.read(buffers);
    }
}
