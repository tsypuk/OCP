package ocp8.ch3;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by rtsy on 05.03.2016.
 */
public class NavigableSample {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(40, "John Lenon");
        map.put(50, "Mr Bean");
        map.put(10, "Denny Moor");

        System.out.println("Exam score: " + map);
        System.out.println("Exam score descending: " + map.descendingMap());
        System.out.println("tail 40: " + map.tailMap(40));
        map.forEach((s, a) -> System.out.println(a));
    }
}