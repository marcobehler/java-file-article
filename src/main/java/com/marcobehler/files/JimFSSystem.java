package com.marcobehler.files;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

public class JimFSSystem {

    public static void main(String[] args) throws IOException {

        try (FileSystem fileSystem = Jimfs.newFileSystem(Configuration.unix());) {
            Path inMemoryFile = fileSystem.getPath("/tmp/somefile.txt");
            Files.writeString(inMemoryFile, "Hello World");

            System.out.println(Files.readString(inMemoryFile));
        }
    }
}
