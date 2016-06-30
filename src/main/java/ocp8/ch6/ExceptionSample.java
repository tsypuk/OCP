package ocp8.ch6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLDataException;
import java.util.IllegalFormatCodePointException;
import java.util.IllegalFormatException;
import java.util.Random;

/**
 * Created by rtsy on 02.03.2016.
 */
public class ExceptionSample {

    public static void main(String[] args) {

        try {
            if (new Random().nextBoolean()) {
                throw new ClassCastException();
            } else {
                throw new FileNotFoundException("NOT FOUND");
            }
//            1. We can not specify the subclass exceptions in multi-catch
//            Error:(16, 42) java: Alternatives in a multi-catch statement cannot be related by subclassing
//            Alternative java.io.FileNotFoundException is a subclass of alternative java.io.IOException

//            2. We can not catch exception that never is thrown in a try block (except RunTimeExceptions)
//            Error:(20, 11) java: exception java.sql.SQLDataException is never thrown in body of corresponding try statement
        } catch (IOException | IllegalFormatException ex) {


//            Error:(26, 13) java: multi-catch parameter ex may not be assigned
//            ex = new FileNotFoundException();

            System.out.println(ex);
        }
        catch (Exception ex) {
            // This is bad syntax but possible here
            ex = new RuntimeException("TEST RUNTIME");
            ex.printStackTrace();
        }

        while (true) {
            System.out.println("work");
            if (new Random().nextBoolean()) {
                throw new RuntimeException();
            }
            System.out.println("work");
        }

    }
}