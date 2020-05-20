package com.marcobehler.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AbsoluteRelativeFiles {

    public static void main(String[] args) {
        Path p = Paths.get("./src/main/java/../resources/some.properties");
        System.out.println("p.isAbsolute() = " + p.isAbsolute());

        Path p2 = p.toAbsolutePath();
        System.out.println("p2 = " + p2);
        System.out.println("p2.isAbsolute() = " + p2.isAbsolute());

        Path p3 = p.normalize().toAbsolutePath();
        System.out.println("p3 = " + p3);
        System.out.println("p3.isAbsolute() = " + p3.isAbsolute());

        // p.isAbsolute() = false
        //p2 = C:\dev\java-file-article\.\src\main\java\..\resources\some.properties
        //p2.isAbsolute() = true
        //p3 = C:\dev\java-file-article\src\main\resources\some.properties
        //p3.isAbsolute() = true
        //relativizedPath = src\main\resources\some.properties

        Path relativizedPath = Paths.get("C:\\dev\\java-file-article\\").relativize(p3);
        System.out.println("relativizedPath = " + relativizedPath);

    }

}
