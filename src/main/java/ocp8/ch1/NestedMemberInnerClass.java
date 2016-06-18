package ocp8.ch1;

import java.io.Serializable;

/**
 * Created by roman.tsypuk on 6/18/16.
 * Member inner class:
 * 1. Can be declared public, private, protected or default
 * 2. Can extend any class and implement interface
 * 3. Can be abstract or final
 * 4. Cannot declare static fields or methods
 * 5. Can access members of the outer class including private fields
 */
public class NestedMemberInnerClass {
    private String greeting = "Hi";
    private String x = "OuterX";

    public class Inner implements Serializable {
        public int repeat = 3;
        private String x = "InnerX";
        public static final String NAME = "CONST"; //   This is allowed for static final constant variables
/*
        Error:(12, 30) java: Illegal static declaration in inner class ocp8.ch1.NestedMemberInnerClass.Inner
        modifier 'static' is only allowed in constant variable declarations
        public static String NAME2 = "CONST";
*/

        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting); //    We have access to outer private fields
            }
        }

        public void finAllX() {
            System.out.println(x);
            System.out.println(this.getClass().getCanonicalName() + " : " + this.x);
            System.out.println(NestedMemberInnerClass.this.x);
        }

/*
        Error:(18, 28) java: Illegal static declaration in inner class ocp8.ch1.NestedMemberInnerClass.Inner
        modifier 'static' is only allowed in constant variable declarations
        public static void say() {
            System.out.println("SAY");
        }
*/
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

//    public static void main(String[] args) {
//        NestedMemberInnerClass outer = new NestedMemberInnerClass();
//        outer.callInner();
//    }

    public static void main(String[] args) {
/*
        Delegation call - this work ok
        NestedMemberInnerClass outer = new NestedMemberInnerClass();
        outer.callInner();

*/
        NestedMemberInnerClass outer = new NestedMemberInnerClass();
        Inner inner = outer.new Inner(); // This construction does not used often but it is real
/*
        Error:(54, 23) java: non-static variable this cannot be referenced from a static context
        Inner is in outer - we need know what outer instance needs to associate the Inner object.
        Inner inner = new Inner();
*/
        inner.go();
        inner.finAllX();
    }
}