package ocp7.chapter7;

import java.io.IOException;

/**
 * Created by rtsy on 14.10.2015.
 */
public class Supressed {

    public static void main(String[] args) {
        try (One one = new One(); Two two = new Two()) {
            throw new Exception("Try");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println("supressed: " + t);
                for (Throwable t1 : t.getSuppressed()) {
                    System.out.println("inner: " + t1);
                }
            }
        }
    }

    static class One implements AutoCloseable {

        @Override
        public void close()
                throws Exception {
            throw new IOException("Closing A");
        }
    }

    static class Two implements AutoCloseable {

        @Override
        public void close()
                throws Exception {
            throw new IOException("Closing B");
        }
    }
}