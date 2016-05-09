package ocp8.ch3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rtsy on 05.03.2016.
 * Bad practice example, but this show the usage of raw type, compilation errors, warnings and runtime exceptions.
 */
public class RawType {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("First");
        list.add("Second");
        list.add(123);
        list.add(10);
//        Warning:(13, 17) java: unchecked call to add(E) as a member of the raw type java.util.List
//        Warning:(14, 17) java: unchecked call to add(E) as a member of the raw type java.util.List
//        Warning:(15, 17) java: unchecked call to add(E) as a member of the raw type java.util.List
//        Warning:(16, 17) java: unchecked call to add(E) as a member of the raw type java.util.List
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        List<String> stringList = list;
//        Warning:(26, 35) java: unchecked conversion
//        required: java.util.List<java.lang.String>
//        found:    java.util.List

//        for (String str : stringList) {
//            System.out.println(str);
//            Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
//        }
        Iterator iterator1 = stringList.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            if (value instanceof String) {
                System.out.println(value);
            } else {
                System.out.println("Not a string: " + value);
            }
        }
    }
}