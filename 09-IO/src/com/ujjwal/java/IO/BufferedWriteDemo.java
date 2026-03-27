package com.ujjwal.java.IO;

import java.io.*;

public class BufferedWriteDemo {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw =
                new BufferedWriter(new FileWriter("demo.txt"));

        bw.write("Hello Buffered IO");
        bw.newLine();
        bw.write("Second Line");

        bw.close();
    }
}