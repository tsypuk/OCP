package ocp8.ch3;

import java.util.*;

/**
 * Created by rtsy on 05.03.2016.
 */
public class NavigableSample {

    public static void main(String[] args) {
        navigableSet();
//        navigableMap();
    }

    private static void navigableSet() {
        NavigableSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        System.out.println(set.lower(2));   //  1   <e
        System.out.println(set.floor(2));   //  2   <=e
        System.out.println(set.ceiling(2)); //  2   >=e
        System.out.println(set.higher(2));  //  3   >e
    }

    private static void navigableMap() {
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