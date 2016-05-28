package ocp8.ch7.concCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWriteArrayListEx {
    public static void main(String[] args) {
        runCopyOnWriteArrayList();

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));
    }

    /**
     * Created by rtsy on 13.02.2016.
     * This works because CopyOnWriteArrayList uses
     * COWIterator<E> implements ListIterator<E> {
     * private final Object[] snapshot;
     * private int cursor;
     * when there is a call from foreach loop - new Instance of COWIterator is returned
     * this iterator has elements snapshot and cursor for returning on every iteration step.
     * So every copy of COWIterator has its own collection of elements.
     */
    private static void runCopyOnWriteArrayList() {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(2, 5, 12, 202));
        for (Integer item : list) {
            System.out.println("item=" + item + "size:" + list.size());
            list.add(7);
        }
        System.out.println("result: " + list);
    }
}