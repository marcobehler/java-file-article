package com.marcobehler.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class DeleteMoveFiles {

    public static void main(String[] args) throws IOException {

        Path utfFile = Files.createTempFile("some", ".txt");

        try {
            Files.move(utfFile, Path.of("c:\\dev"));  // this is wrong!
        } catch (FileAlreadyExistsException e) {
            // welp, that din't work!
        }

        Files.move(utfFile, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()));


        Path utfFile2 = Files.createTempFile("some", ".txt");
        Files.move(utfFile2, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

        Path utfFile3 = Files.createTempFile("some", ".txt");
        Files.move(utfFile3, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);


        Path tmpDir = Files.createTempDirectory("somePrefix");
        Path fileInTmpDir = Files.createTempFile(tmpDir, "somePrefix", ".txt");

        try {
            Files.delete(tmpDir);
        } catch (DirectoryNotEmptyException e) {
            e.printStackTrace();
        }

        try (Stream<Path> walk = Files.walk(tmpDir)) {
            walk.sorted(Comparator.reverseOrder()).forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    // something could not be deleted..
                    e.printStackTrace();
                }
            });
        }
    }

    //sort the list in reverse order, so the directory itself comes after the including subdirectories and files
}
