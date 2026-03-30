package com.ujjwal.java.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select(); // blocking until event occurs

            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                SelectionKey key = keys.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);

                    client.register(selector, SelectionKey.OP_READ);
                }

                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    System.out.println("Data ready to read...");
                }

                keys.remove();
            }
        }
    }
}
