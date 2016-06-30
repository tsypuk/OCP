package ocp8.ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by roman.tsypuk on 6/30/16.
 */
public class TryWithResources {

    public static void main(String[] args) {
//        readFiles();
//        tryAutoClosableResource();
//        towSupressed();
//        supressed();
    }



    private static void tryAutoClosableResource() {
        try (TurkeyCage turkeyCage = new TurkeyCage()) {
            System.out.println("This is new turkey" + turkeyCage);
        }

        /*
        1. Add catch clause
        2. Add exception to method signature
        3. Surround with try/catch
        */
        try (TurkeyCageWithException turkeyCageWithException = new TurkeyCageWithException()) {
            System.out.println("This is tukey with exception" + turkeyCageWithException);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFiles(Path path1, Path path2) throws IOException {
        int a = 1;
        try (BufferedReader r1 = Files.newBufferedReader(path1);
             BufferedReader r2 = Files.newBufferedReader(path2)) {
            int b = 1;
        } catch (RuntimeException ex) {
            a = 2;
//            b = 3; //Error:(24, 13) java: cannot find symbol symbol:   variable b location: class ocp8.ch6.TryWithResources

            System.out.println("CATCHED");
        } finally {
            a = 3;
        }
    }
}

class TurkeyCage implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Cage is closed");
    }
}

class TurkeyCageWithException implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Cage with exception");
    }
}

class TurkeyCageRuntimeException implements AutoCloseable {
    @Override
    public void close() {
        throw new IllegalStateException("Cage door does not close.");
    }
}