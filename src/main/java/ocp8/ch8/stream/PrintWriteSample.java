package ocp8.ch8.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by rtsy on 28.02.2016.
 */
public class PrintWriteSample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("line.separator"));
        Properties properties = System.getProperties();
        System.out.println(properties);
        File source = new File("zoo.log");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
            out.print("Some text at the begining");
            out.println(" now on new line");
            out.print('c');
            out.format("format %d", 10);
            out.format(Locale.ENGLISH, "my text %s %d", "str", 33);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}