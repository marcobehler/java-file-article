package com.marcobehler.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ReadingFiles {

    public static void main(String[] args) throws IOException {
        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8

        String s = Files.readString(utfFile);// UTF 8
        System.out.println("s = " + s);

        s = Files.readString(utfFile, StandardCharsets.ISO_8859_1); // otherwise == utf8
        System.out.println("s = " + s);

        s = new String(Files.readAllBytes(utfFile), StandardCharsets.UTF_8);
        System.out.println("s = " + s);


        try (BufferedReader bufferedReader = Files.newBufferedReader(utfFile)) {
            // handle reader
        }

        try (InputStream is = Files.newInputStream(utfFile)) {
            // handle inputstream
        }
    }
}
