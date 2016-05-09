package ocp8.ch7.stream;

import java.util.Arrays;

/**
 * Created by rtsy on 16.02.2016.
 */
public class StreamsRun {

    public static void main(String[] args) {
        Arrays.asList("jackal", "kangaroo", "lemur", "lion", "dog")
                .parallelStream()
                .peek(s -> {System.out.println("::" + s);})
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}