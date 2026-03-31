package com.ujjwal.java.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class SimpleServer {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8080));

        System.out.println("Server started on port 8080...");

        while (true) {
            server.accept(); // blocking
            System.out.println("Client connected");
        }
    }
}
