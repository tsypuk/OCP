package ocp8.ch3;

import java.util.*;
import java.util.Collections;

/**
 * Created by rtsy on 05.03.2016.
 */
public class Iterators  {
    public static void main(String[] args) {
        testIterator();
        testRetain();
    }

    private static void testIterator() {
        List<Integer> integerList = Arrays.asList(1, 10, 10, 15, 17);

        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        ListIterator<Integer> listIterator = integerList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.nextIndex());
            System.out.println(listIterator.next());
        }
//        integerList.removeAll(Arrays.asList(new Integer[] {Integer.valueOf(10)}));
//        System.out.println(integerList);
    }

    /**
     * Retain leaves only element that match in both lists.
     */
    private static void testRetain() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        System.out.println(integerList);
        integerList.retainAll(Arrays.asList(1, 3, 4, 15));
        System.out.println(integerList);
    }
}