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

//1. Problem with Traditional IO
//1 Thread = 1 Connection
    //Not scalable
    //High memory usage
    //Thread blocking
//2.NIO Solution
    //1 Thread → Multiple Connections
    //Using:Selector
    //Channels
    //Non-blocking mode
//3. Core Components
//1. Channel
//SocketChannel
//ServerSocketChannel
//2. Buffer
//Data container
//3. Selector
    //Monitors multiple channels
//4. Selector Concept (VERY IMPORTANT)
    //Selector allows:Monitor multiple channels for events
    //Events:Accept,Connect,Read,Write
//5. Basic Flow
    //1. Create Selector
    //2. Register channels
    //3. Wait for events
    //4. Process events
//
//7. Key Concepts to Understand Deeply
    //SelectionKey Represents:Channel + Event Interest
    //OP Codes:
    //Operation	Meaning
    //OP_ACCEPT	New connection
    //OP_CONNECT	Connection established
    //OP_READ	Data available
    //OP_WRITE	Ready to write
//8. Why This Matters (Real Systems)
    //This is used in:Netty
    //Spring WebFlux
    //High-scale servers (millions of requests)
//9. Blocking vs Non-Blocking (Interview Gold)
    //Feature	Blocking	Non-Blocking
    //Threads	1 per request	Few threads
    //Performance	Low	High
    //Scalability	Poor	Excellent
//10. Real Backend Insight
    //You will not write raw selectors in jobs.
    //But:Understanding this = understanding how backend frameworks work internally