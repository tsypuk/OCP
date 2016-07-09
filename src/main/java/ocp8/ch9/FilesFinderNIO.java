package ocp8.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

/**
 * Created by rtsy on 08.03.2016.
 */
public class FilesFinderNIO {

    public static void main(String[] args) {
//        Path startFile = Paths.get("C:\\cygwin64");
//        Stream<Path> stream = Files.walk(startFile, FileVisitOption.FOLLOW_LINKS);
//        System.out.println(stream.peek(System.out::println).count());

//        filterFiles();
//        iterateFilesInfinite();
        iterateFiles();
    }

    private static void filterFiles()
            throws IOException {
        BiPredicate<Path, BasicFileAttributes> predicate = (path, attrs)
        -> attrs.isRegularFile();

        try (Stream<Path> entries = Files.find(Paths.get("C:\\"), 4, predicate)) {
            entries.forEach(System.out::println);
        }
    }

    /**
     * Infinite loop
     */
    private static void iterateFilesInfinite() {
        Path path = Paths.get("D:\\docs");
        while (path.iterator().hasNext()) {
            System.out.println(path.iterator().next());
        }
    }

    private static void iterateFiles() {
        Path path = Paths.get("D:\\docs\\debug_ibatis_query.docx");
        Iterator<Path> iterator = path.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Path file : path) {
            System.out.println(file);
        }
    }
}