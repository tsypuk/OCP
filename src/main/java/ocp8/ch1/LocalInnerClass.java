package ocp8.ch1;

/**
 * Created by roman.tsypuk on 6/18/16.
 * Local inner class - nested class defined within a method:
 * 1. they do not have an access specifier
 * 2. they cannot be declared static and cannot declare static fields or methods
 * 3. they have access to all fields and methods of the enclosing class
 * 4. they do not have access to local variables of the method unless those variables are final or effectively final.
 */
public class LocalInnerClass {
    private int length = 5;
    public void calculate(int x) {
        length++;
        int width = 20;
//        width += x;
//        Error:(20, 45) java: local variables referenced from an inner class must be final or effectively final


//        private Error:(15, 9) java: illegal start of expression
        class Inner {
            public void multiply() {
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.length ++;
        localInnerClass.calculate(5);
    }

}