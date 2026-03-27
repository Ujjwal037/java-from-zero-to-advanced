package com.ujjwal.java.IO;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("demo.txt");

        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }

        fis.close();
    }
}
