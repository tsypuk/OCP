package ocp8.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rtsy on 07.02.2016.
 */
public class Collections {

    public static void main(String[] args) {
        sortRabbits();
        sortComparableRabbits();
        reverseOrderSearch();

        exceptionInTreeSet();

        comparatorWithHelper();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.replaceAll(x -> x * 2);
        System.out.println(list);

    }

    private static void comparatorWithHelper() {
        Comparator<Rabbit> byId = (r1, r2) -> RabbitHelper.compareById(r1, r2);
        Comparator<Rabbit> byName = (r1, r2) -> RabbitHelper.compareByName(r1, r2);
        Comparator<Rabbit> byId2 = RabbitHelper::compareById;
        Comparator<Rabbit> byName2 = RabbitHelper::compareByName;
    }

    private static void exceptionInTreeSet() {
        Set<Rabbit> rabbits = new TreeSet<>();
//        rabbits.add(new Rabbit(3, "Alpha"));
        //Exception in thread "main" java.lang.ClassCastException: ocp8.ch3.Collections$Rabbit cannot be cast to java.lang.Comparable
    }

    private static void reverseOrderSearch() {
        List<String> names = Arrays.asList("Alpha", "Roger", "Tango");
        Comparator<String> namesComparatorReverseOrder = Comparator.reverseOrder();
        Comparator<String> namesComparator = (n1, n2) -> n1.compareTo(n2);
//        java.util.Collections.sort(names, namesComparator);
//        System.out.println(names);
        int index = java.util.Collections.binarySearch(names, "Tango", namesComparator);
        System.out.println(index);

        int index2 = java.util.Collections.binarySearch(names, "Tango", namesComparatorReverseOrder);
        System.out.println(index2);
    }

    private static void sortComparableRabbits() {
        List<RabbitComparable> rabbitComparables = new ArrayList<>();
        rabbitComparables.add(new RabbitComparable(2, "Bravo"));
        rabbitComparables.add(new RabbitComparable(1, "Tango"));
        rabbitComparables.add(new RabbitComparable(5, "Foxtrot"));
        java.util.Collections.sort(rabbitComparables);
        System.out.println(rabbitComparables);
    }

    private static void sortRabbits() {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(3, "Bravo"));
        rabbits.add(new Rabbit(5, "Foxtrot"));
        rabbits.add(new Rabbit(1, "Alpha"));
//        java.util.Collections.sort(rabbits); DOES NOT Compile not comprable implementation
        Comparator<Rabbit> comparator = new Comparator<Rabbit>() {
            @Override
            public int compare(Rabbit o1, Rabbit o2) {
                return o1.id - o2.id;
            }
        };
        java.util.Collections.sort(rabbits, comparator);
        System.out.println(rabbits);

        Comparator<Rabbit> rabbitComparator = (r1, r2) -> r1.id - r2.id;
    }

    static class Rabbit {
        int id;
        String name;

        Rabbit(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Rabit{" +
                    "id=" + id +
                    "name=" + name +
                    '}';
        }
    }

    static class RabbitComparable extends Rabbit implements Comparable<RabbitComparable> {
        RabbitComparable(int id, String name) {
            super(id, name);
        }

        @Override
        public int compareTo(RabbitComparable o) {
            return this.id - o.id;
        }
    }
}

class RabbitHelper {

    public static int compareById(Collections.Rabbit r1, Collections.Rabbit r2) {
        return r1.id - r2.id;
    }

    public static int compareByName(Collections.Rabbit r1, Collections.Rabbit r2) {
        return r1.name.compareTo(r2.name);
    }
}