package main.java;

import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rtsy on 16.12.2015.
 */
public class CompaterTest {
    List<Integer> list;

    @Before
    public void setUp()
            throws Exception {
        list = Arrays.asList( -1, 10, 6, 2, 4, 1, 5, 10, 11, 10, 42, 42, 42, 42, 30, 7, -1, 14, 10);
    }

    @Test
    public void test() {
        Collections.sort(list, getComparator());

        System.out.println(list);
        Iterator<Integer> iter = list.iterator();
        int prev = iter.next();
        int current = 0;
        while (iter.hasNext()) {
            current = iter.next();
            assertTrue(prev <= current);
            prev = current;
        }
    }

    private static Comparator<Integer> getComparator() {
        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
                return o1 < o2 ? -1 : 1;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer>list = Arrays.asList( -1, 10, 6, 2, 4, 1, 5, 10, 11, 10, 42, 42, 42, 42, 42, 30, 7, -1, 14, 10);
        for (int i = 0; i < 100; i++) {
            Collections.shuffle(list);
            Collections.sort(list, getComparator());
            System.out.println("Sort: " + list);
        }

        int[] array = {1,4,5,6,7,1,2,23,5,2,78,9,1,3};
        for (int i = 0; i < 100; i++) {

            Arrays.sort(array);
        }
    }
}