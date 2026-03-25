package com.ujjwal.java.IO;
import  java.nio.file.*;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("demo.txt");

        // Write
        Files.writeString(path, "Hello IO-NIO");

        // Read
        String data = Files.readString(path);
        System.out.println(data);

        // Copy
        Path copy = Paths.get("copy.txt");
        Files.copy(path, copy, StandardCopyOption.REPLACE_EXISTING);

        // Delete
        Files.delete(copy);
    }
}


