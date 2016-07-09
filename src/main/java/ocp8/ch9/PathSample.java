package ocp8.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/**
 * Created by rtsy on 08.03.2016.
 */
public class PathSample {
    public static void main(String[] args)
            throws IOException {
        baseFileOperations();
//        compareFiles();
    }

    private static void baseFileOperations() {
        Path testFile = Paths.get("d:\\Tools\\apache-jmeter-2.13\\bin\\12.csv");

        System.out.println("FileName" + testFile.getFileName());
        System.out.println("Root" + testFile.getRoot());
        System.out.println("Parent " + testFile.getParent());
        System.out.println("URI: " + testFile.toUri());
        System.out.println("Absolute path: " + testFile.toAbsolutePath());
        System.out.println("Normalize: " + testFile.normalize());

        System.out.println("foreach");
        for (Path element : testFile) {
            System.out.println(element);
        }
    }

    private static void compareFiles()
            throws IOException {
        Path path1 = Paths.get("Animal");
        Path path2 = Paths.get("D:\\docs\\idea_proj\\OCP8\\Animal");
        System.out.println("equals:");
        System.out.println(path1.equals(path2));
        System.out.println(path2.equals(path1));
        System.out.println("P1 compare P2: " + path1.compareTo(path2));
        System.out.println("P2 compare P1: " + path2.compareTo(path1));
        System.out.println(path1.toAbsolutePath().equals(path2.toAbsolutePath()));
        System.out.println(Files.isSameFile(path1, path2));
        showFileAttributes(path1);

    }

    private static void showFileAttributes(Path path1)
            throws IOException {
        BasicFileAttributes attr = Files.readAttributes(path1, BasicFileAttributes.class);
        System.out.println(attr.creationTime());
        System.out.println(attr.lastModifiedTime());
        System.out.println(attr.size());
        System.out.println(attr.lastAccessTime());


        DosFileAttributes attributes = Files.readAttributes(path1, DosFileAttributes.class);
        System.out.println(attributes);
    }
}