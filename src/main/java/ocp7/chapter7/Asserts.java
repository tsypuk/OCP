package ocp7.chapter7;

/**
 * Created by rtsy on 14.10.2015.
 */
public class Asserts {
    public static void main(String[] args) {
        System.out.println("Testing asserts");
        String name = "Roman";
        assert name.length() > 10 : "Too small";
        assert name != null;
    }
}
