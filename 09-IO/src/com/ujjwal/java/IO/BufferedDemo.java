package com.ujjwal.java.IO;

import java.io.*;

public class BufferedDemo {

    public static void main(String[] args) throws IOException {

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream("demo.txt"));

        int data;
        while ((data = bis.read()) != -1) {
            System.out.print((char) data);
        }

        bis.close();
    }
}
