package com.ujjwal.java.IO;

import java.nio.file.*;
import java.io.IOException;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get(".");

        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);

        for (Path file : stream) {
            System.out.println(file.getFileName());
        }
        //✅ Create Directory
        Files.createDirectory(Paths.get("newFolder"));
        //✅ Create Nested Directories
        Files.createDirectories(Paths.get("parent/child/grandchild"));

        //Copy
        Files.copy(
                Paths.get("source.txt"),
                Paths.get("dest.txt"),
                StandardCopyOption.REPLACE_EXISTING
        );
        //Move / Rename
        Files.move(
                Paths.get("old.txt"),
                Paths.get("new.txt")
        );
        //Delete
        Files.delete(Paths.get("file.txt"));

        //File Attributes (Interview + Real Use)
        Path path = Paths.get("data.txt");

        System.out.println("Size: " + Files.size(path));
        System.out.println("Exists: " + Files.exists(path));
        System.out.println("Readable: " + Files.isReadable(path));

        Files.lines(path).forEach(System.out::println);
//        Real-World Use Cases
//        You’ll use this in: - Log processing, File uploads (Spring Boot), CSV processing, Batch jobs, Data pipelines

    }


}