package ocp8.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by roman.tsypuk on 7/9/16.
 */
public class PathOperations {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("/dev/");
        Path path2 = Paths.get("food");

        System.out.println(path2.resolve(path1));
        System.out.println(path1.resolve(path2));

        System.out.println(path1.resolve(path2).normalize());
        System.out.println(path1.toRealPath());

        System.out.println(Files.exists(path1));
        System.out.println(Files.exists(path2));


    }
}
