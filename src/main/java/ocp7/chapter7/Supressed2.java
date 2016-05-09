package ocp7.chapter7;

import java.io.IOException;

/**
 * Created by rtsy on 14.10.2015.
 */
public class Supressed2 {
    public static void main(String[] args) {
        try (Bad b1 = new Bad("1"); Bad b2 = new Bad("2")){

        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println("supressed:" + t);
            }
        }
    }

    static class Bad implements AutoCloseable {
        String name;

        Bad(String name) {
            this.name = name;
        }

        @Override
        public void close()
                throws Exception {
            throw new IOException("closing " + name);
        }
    }
}
