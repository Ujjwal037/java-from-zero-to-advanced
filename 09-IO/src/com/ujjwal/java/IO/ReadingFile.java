package com.ujjwal.java.IO;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class ReadingFile {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data.txt");

        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}