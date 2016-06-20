package ocp8.ch3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by roman.tsypuk on 6/20/16.
 */
public class Sout {
    public static void main(String[] args) {
        String[] names = {"A", "B", "c"};
        List<String> list = Arrays.asList(names);
/*
        java.lang.UnsupportedOperationException
        at java.util.AbstractList.add(AbstractList.java:148)
        list.add("D");
*/

        List<String> list2 = Arrays.asList(new String[]{"A", "B", "C"});
        list.set(2, "C1");
        names[0] = "A1";
        String name = list.get(0);
        System.out.println(names); //[Ljava.lang.String;@5a07e868
        System.out.println(list); //[A, B, c]
        System.out.println(list2); //[A, B, C]
    }
}
