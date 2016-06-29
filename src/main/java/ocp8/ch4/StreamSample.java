package ocp8.ch4;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;

/**
 * Created by rtsy on 29.02.2016.
 */
public class StreamSample {

    public static void main(String[] args) {
//        filterLimitIntegerStream();
//        reduceStringStream();
//        optionalInStream();
//        generateStream();
//        streamMethods();
//        getStreamMax();
//        getStreamMap();

//        reduceWithBinaryOperator();
//        reduceParallel(1000_000_000);
//        collector();
//        distinct();
//        limitSkip();
//        Stream<String> stream = getStringStream();
//        stream.map(String::length).forEach(System.out::println);
//        flatMap();
//        peek();
//        mapToInt();
//        range();
//        avr();


//        stat();
        System.out.println(
        Stream.iterate(1, x -> ++x)
            .limit(5)
            .map(x -> ""+ x)
            .collect(java.util.stream.Collectors.joining())
        );
    }

    private static void stat() {
        IntStream stream = IntStream.range(10, 100);
        IntSummaryStatistics stat = stream.summaryStatistics();
        System.out.println(stat.toString());
    }

    private static void avr() {
        //        avr
        System.out.println(IntStream.rangeClosed(1, 100).average().orElse(0));
    }

    private static void mapToInt() {
        Stream<String> stream = Stream.of("lion", "tiger", "dog", "elephant");
        IntStream intStream = stream.mapToInt(animal -> animal.length());
        intStream.sorted().forEach(System.out::println);
    }

    private static void range() {
        //        Exclusive
        IntStream.range(1, 10).forEach(System.out::println);
//        Inclusive
        IntStream.rangeClosed(1, 10).forEach(System.out::print);
    }

    private static void peek() {
        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite.limit(7)
                .peek(System.out::println)
                .filter(x -> x % 2 == 1)
//                .sorted()
                .forEach(System.out::println);
    }

    private static void flatMap() {
        List<String> zero = Arrays.asList();
        List<String> three = Arrays.asList("Gorillaz", "Nirvana", "Baby", "Bonobo");
        List<String> two = Arrays.asList("News", "Latters", "Gallery");

        Stream<List<String>> streamAnimals = Stream.of(zero, three, two);
        streamAnimals.flatMap(animals -> animals.stream()).sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void limitSkip() {
        Stream<Integer> stream = Stream.iterate(1, a -> a + 1);
        stream.skip(100).limit(100).forEach(System.out::println);
    }

    private static void distinct() {
        Stream<String> stream = getStringStream();
        stream.distinct().forEach(System.out::println);
    }

    private static void collector() {
        Stream<String> stringStream = getStringStream();
        StringBuilder result = stringStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(result);

        stringStream = getStringStream();
        TreeSet<String> treeSet = stringStream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(treeSet);
    }

    private static void reduceParallel(int count) {
        Stream<Double> integerStream = Stream.generate(() -> 1D);
        double result = integerStream.limit(count).parallel().reduce((a, b) -> a + b).orElse(0D);
        System.out.println(result);
    }

    private static void reduceWithBinaryOperator() {
        Stream<String> stringStream = Stream.of("alpha", "bravo", "tango", "foxtrot");
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        int result = stringStream.map(String::length).reduce(binaryOperator).orElse(0);
        System.out.println(result);
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
                .peek((s) -> {
                    System.out.println("After limit:" + s);
                })
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
        String[] array = new String[]{"w", "o", "l", "f"};
        String result = "";
        for (String s : array) {
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
