package ocp8.ch4;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 6/28/16.
 */
public class CollectorsTest {

    @Test
    public void testJoiningDelimiter() {
        assertEquals("one, two, three", Stream.of("one", "two", "three").collect(java.util.stream.Collectors.joining(", ")));
    }

    @Test
    public void testJoining() {
        assertEquals("onetwothree", Stream.of("one", "two", "three").collect(java.util.stream.Collectors.joining()));
    }

    @Test
    public void testHashMap() {
        Map<String, Integer> map = Stream.of("one", "two", "three").collect(Collectors.toMap(s -> s, String::length));
        assertTrue(map.size() == 3);
        assertEquals(HashMap.class, map.getClass());
        System.out.println(map);
    }

    @Test
    public void testTreeMap() {
        Map<Integer, String> map = Stream.of("one", "two", "three")
                .collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "" + s2, TreeMap::new));
        assertTrue(map.size() == 2);
        assertEquals(TreeMap.class, map.getClass());
        System.out.println(map);
    }

    @Test
    public void testTreeMap2() {
        Map<String, Integer> map = Stream.of("one", "two", "three", "two")
                .collect(Collectors.toMap(k -> k, String::length, (a1, a2) -> a1, TreeMap::new));
        assertTrue(map.size() == 3);
        assertEquals(TreeMap.class, map.getClass());
        System.out.println(map);
    }
}