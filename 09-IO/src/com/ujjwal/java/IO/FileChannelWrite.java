package com.ujjwal.java.IO;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWrite {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("output.txt", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.put("Hello NIO Channel".getBytes());

        buffer.flip();

        channel.write(buffer);

        channel.close();
        file.close();
    }
}