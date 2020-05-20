package com.marcobehler.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ListingFiles {

    public static void main(String[] args) throws IOException {

        Path tmpDirectory = Files.createTempDirectory("somePrefix");

        Files.list(tmpDirectory).forEach(System.out::println);

        Files.newDirectoryStream(tmpDirectory, "*.txt").forEach(System.out::println);

        Files.walk(tmpDirectory).forEach(System.out::println);

    }
}
