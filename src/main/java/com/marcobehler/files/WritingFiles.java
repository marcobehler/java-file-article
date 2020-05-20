package com.marcobehler.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WritingFiles {

    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8
        System.out.println("utfFile = " + utfFile);

        Path iso88591File = Files.createTempFile("some", ".txt");
        Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
        System.out.println("iso88591File = " + iso88591File);

        Path anotherIso88591File = Files.createTempFile("some", ".txt");
        Files.write(anotherIso88591File, "this is my string ää öö üü".getBytes(StandardCharsets.ISO_8859_1));
        System.out.println("anotherIso88591File = " + anotherIso88591File);

        Path anotherUtf8File = Files.createTempFile("some", ".txt");
        Files.writeString(anotherUtf8File, "this is my string ää öö üü", StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("anotherUtf8File = " + anotherUtf8File);

        Path oneMoreUtf8File = Files.createTempFile("some", ".txt");
        Files.write(oneMoreUtf8File, "this is my string ää öö üü".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
        System.out.println("oneMoreUtf8File = " + oneMoreUtf8File);

        // Files.newOutputStream();
        // Files.newBufferedReader()

    }
}
