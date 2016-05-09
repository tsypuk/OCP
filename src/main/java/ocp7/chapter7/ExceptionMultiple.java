package ocp7.chapter7;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.stream.Stream;

/**
 * Created by rtsy on 14.10.2015.
 */
public class ExceptionMultiple {

    /**
     *  Multicatch bloch
     * @param args
     */
    public static void main(String[] args) {
        try {
            File file = new File("path");
            if (file.getName().isEmpty()) {
                throw new IOException();
            }
            else {
                throw new SQLException();
            }
        }
        catch (IOException | SQLException ex) {
            System.out.println("Error processing " + ex);
        }
    }

    private void ahh()
            throws AException, BException {
        try {
            rain();
        } catch (AException | BException e) {
            throw e;
        }
    }
    private void rain() throws AException, BException {

    }

    private class AException extends Exception {}
    private class BException extends Exception {}

    /**
     * Try with resources
     */
    private void tryRes() {
        try (Reader reader = new BufferedReader(new FileReader("path"))) {

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void noCatch() {
        try (Stream s = Stream.empty()) {

        }
    }
}
