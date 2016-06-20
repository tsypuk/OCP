package ocp8.ch1;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
public class StaticNested {
    static int outerStatic = 10;
    final int outerFinal = 7;
    int outerInstance = 4;
    static class Nested {
        private int price = 6;
        void doStuff() {
            System.out.println(outerStatic);
/*
            Final
            Error:(14, 32) java: non-static variable outerFinal cannot be referenced from a static context
            System.out.println(outerFinal);
*/
/*
            Instance
            Error:(13, 32) java: non-static variable outerInstance cannot be referenced from a static context
            System.out.println(outerInstance);
*/

        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
        nested.doStuff();
    }
}
