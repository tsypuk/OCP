package ocp8.ch4;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by rtsy on 29.02.2016.
 */
public class StreamSmaple {

    public static void main(String[] args) {
//        filterLimitIntegerStream();
//        reduceStringStream();
//        optionalInStream();
//        generateStream();
//        streamMethods();
//        getStreamMax();
        getStreamMap();
    }

    private static void getStreamMax() {
        IntStream integerStream = IntStream.rangeClosed(1, 10);
        OptionalInt result = integerStream.max();
        result.ifPresent(System.out::print);
    }

    private static void getStreamMap() {
        IntStream integerStream = IntStream.rangeClosed(1, 10);
        System.out.println(integerStream.sum());
    }

    private static void generateStream() {
        Stream<Integer> stream = Stream.generate(() -> new Random().nextInt());
        stream.peek(System.out::print)
                .filter(value -> value > 10)
                .limit(20)
                .peek((s) -> {System.out.println("After limit:" + s);})
                .forEach(System.out::print);
    }

    private static void streamMethods() {
        Arrays.stream(Object.class.getMethods())
                .map(method -> method.getName())
                .distinct()
                .forEach(System.out::println);
    }

    private static void optionalInStream() {
        BinaryOperator<Integer> operator = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(2);
        Stream<Integer> threeElements = Stream.of(2, 4, 5);

        Integer result = empty.reduce(operator).orElse(0); // ifPresent(System.out::print);
        System.out.println(result);
        oneElement.reduce(operator).ifPresent(System.out::print);
        System.out.println();
        threeElements.reduce(operator).ifPresent(System.out::print);
    }

    private static void filterLimitIntegerStream() {
        Stream<Integer> integerStream = Stream.iterate(1, x -> x + 1);
        integerStream.filter(x -> x % 2 == 1)
                .peek(System.out::print)
                .limit(4)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void reduceStringStream() {
        String[] array = new String[] {"w", "o", "l", "f"};
        String result = "";
        for (String s: array) {
            result += s;
        }
        System.out.println(result);

        Stream<String> stream = getStringStream();
        String word = stream.reduce("", (s, c) -> s + c);
        System.out.println(word);
        stream = getStringStream();
        word = stream.reduce("", String::concat);
        System.out.println(word);
    }

    public static Stream<String> getStringStream() {
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        return stream;
    }
}
