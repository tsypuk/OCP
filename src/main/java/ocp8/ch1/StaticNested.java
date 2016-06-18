package ocp8.ch1;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
public class StaticNested {
    static int outerStatic = 10;
    int outerInstance = 4;
    static class Nested {
        private int price = 6;
        void doStuff() {
            System.out.println(outerStatic);
/*

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
