package hash;

/**
 * Created by rtsy on 12.03.2016.
 * -XX:hashCode=3 autoincrement
 */

public class HashCodeTest {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i ++)
        System.out.println(new Object().hashCode());
    }
}