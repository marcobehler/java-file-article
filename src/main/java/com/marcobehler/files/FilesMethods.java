package com.marcobehler.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

public class FilesMethods {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");

        boolean exists = Files.exists(path);
        System.out.println("exists = " + exists);

        FileTime lastModifiedTime = Files.getLastModifiedTime(path);
        System.out.println("lastModifiedTime = " + lastModifiedTime);

        long mismatchIndex = Files.mismatch(path, Paths.get("c:\\dev\\whatever.txt"));
        System.out.println("mismatch = " + mismatchIndex);

        UserPrincipal owner = Files.getOwner(path);
        System.out.println("owner = " + owner);

        Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
        System.out.println("tempFile1 = " + tempFile1);

        Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
        System.out.println("tempFile2 = " + tempFile2);

        Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));
        System.out.println("newDirectory = " + newDirectory);

        Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
        System.out.println("newFile = " + newFile);

        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
            System.out.println("permissions = " + permissions);
        } catch (UnsupportedOperationException e) {
            System.err.println("Looks like you're not running on a posix file system");
        }

    }
}
