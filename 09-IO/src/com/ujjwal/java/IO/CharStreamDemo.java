package com.ujjwal.java.IO;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("demo.txt");

        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }

        fr.close();
    }
}
