package com.ujjwal.java.IO;

import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;

public class WritingFile {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("output.txt");

        Files.write(path, Arrays.asList("Hello", "Java NIO"));
//        Append Data
        Files.write(path,
                Arrays.asList("New Line"),
                StandardOpenOption.APPEND);
    }
}
