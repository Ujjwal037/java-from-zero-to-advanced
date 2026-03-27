package com.ujjwal.java.IO;
import java.io.*;

public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new FileReader("demo.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
