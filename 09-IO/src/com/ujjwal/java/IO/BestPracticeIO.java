package com.ujjwal.java.IO;

import java.io.*;

public class BestPracticeIO {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("demo.txt"), "UTF-8"
                        )
                );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
