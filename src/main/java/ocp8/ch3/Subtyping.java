package ocp8.ch3;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by rtsy on 05.03.2016.
 */
public class Subtyping {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<Number>();
        numberList.add(10); //Integer
        numberList.add(10.4); //Double
        numberList.add(15.4F); //Float
        System.out.println(numberList);
//        List<Number> numberIntList = new ArrayList<Integer>();
//        Error:(12, 38) java: incompatible types:
// java.util.ArrayList<java.lang.Integer> cannot be converted to java.util.List<java.lang.Number>

        List<?> wildCardList = new ArrayList<Integer>();
//        The compiler does not allow to call any method that modifies the Collection of WildCards
//        wildCardList.add(4);
//        Error:(21, 21) java: no suitable method found for add(int)
//        method java.util.Collection.add(capture#1 of ?) is not applicable
//                (argument mismatch; int cannot be converted to capture#1 of ?)
//        method java.util.List.add(capture#1 of ?) is not applicable
//                (argument mismatch; int cannot be converted to capture#1 of ?)
        wildCardSuperType();
        testWildCard();
    }

    private static void wildCardSuperType() {
        System.out.println(new ArrayList<Number>() instanceof List<?>);
        System.out.println(new ArrayList<Object>() instanceof List<?>);
        System.out.println(new ArrayList() instanceof List<?>);
//        List<?> is a supertype of any List type
    }

    private static void testWildCard(){
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(10);
        integerList.add(4);
        wildCardPrint(integerList);

        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        wildCardPrint(stringList);
    }

    private static void wildCardPrint(List<?> list) {
        for (Object element : list) {
            System.out.println("["+ element+"]");
        }
    }
}