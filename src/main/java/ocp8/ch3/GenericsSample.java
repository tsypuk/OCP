package ocp8.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rtsy on 31.01.2016.
 */
public class GenericsSample {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Test");
        stringList.add("New");
        System.out.println(stringList);

        List<Object> objects = new ArrayList<>();

        String[] str = {"1", "2", "3"};
        Object[] objs = str;
        System.out.println(objs);
    }

}

class X<T> {
    T instanceMem;

    //        static T staticMem;
//        Error:(29, 16) java: non-static type variable T cannot be referenced from a static context
//        Error:(29, 18) java: Illegal static declaration in inner class ocp8.ch3.GenericsSample.X
//        modifier 'static' is only allowed in constant variable declarations
    void dostuff() {
//            T mem = new T(); Can not instantiate
//            T[] array = new T[100]; Can not instantiate array
    }
}