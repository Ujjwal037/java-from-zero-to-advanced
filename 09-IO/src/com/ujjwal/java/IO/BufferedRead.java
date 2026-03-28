package com.ujjwal.java.IO;

import java.nio.file.*;
import java.io.*;

public class BufferedRead {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data.txt");

        BufferedReader reader = Files.newBufferedReader(path);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
