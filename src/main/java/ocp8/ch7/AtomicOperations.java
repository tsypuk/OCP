package ocp8.ch7;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Created by roman.tsypuk on 7/3/16.
 */
public class AtomicOperations {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println(atomicBoolean.get());
        System.out.println(atomicBoolean.getAndSet(true));
        System.out.println(atomicBoolean.get());

        AtomicInteger integer = new AtomicInteger();
        System.out.println(integer.incrementAndGet());
        System.out.println(integer.getAndDecrement());

        AtomicLongArray array = new AtomicLongArray(new long[]{2,3,4,5,6,7});
        System.out.println(array);
        array.incrementAndGet(0);
        System.out.println(array);
    }
}
