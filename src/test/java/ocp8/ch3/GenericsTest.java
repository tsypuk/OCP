package ocp8.ch3;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenericsTest {

    @Test
    public void testParent() {
        String[] str = {"a", "b"};
        assertTrue(str instanceof Object[]);
        assertTrue(str instanceof String[]);
    }

    @Test
    public void testSuper() {
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(new Integer(1));
        numbers.add(new Double(1.2));


        List<? super IOException> exceptions = new ArrayList<Exception>();
        exceptions.add(new IOException());
//        exceptions.add(new Exception());
        /*
        Error:(24, 19) java: no suitable method found for add(java.lang.Exception)
    method java.util.Collection.add(capture#1 of ? super java.io.IOException) is not applicable
      (argument mismatch; java.lang.Exception cannot be converted to capture#1 of ? super java.io.IOException)
    method java.util.List.add(capture#1 of ? super java.io.IOException) is not applicable
      (argument mismatch; java.lang.Exception cannot be converted to capture#1 of ? super java.io.IOException)
         */
    }

    @Test
    public void testExtends() {
        List<? extends IOException> exceptions = new ArrayList<IOException>();
//        exceptions.add(new IOException());
    }
}