package ocp8.ch1;

import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;
       /*
        * Class hierarchy:
        *
        *  HeavyAnimal
        *      |       |
        *      Hippo   Elephant
        *         |
        *         |
        * Mother  |
        * |       |
        * MotherHippo
        */
public class InatanceOfTest {
    final HeavyAnimal hippo = new Hippo();

    @Test
    public void testInstance() {
        assertTrue(hippo instanceof Hippo);
        assertTrue(hippo instanceof HeavyAnimal);
        assertFalse(hippo instanceof Elephant);

        /*
        Hippo hippo1 = new Hippo();
        assertFalse(hippo1 instanceof Elephant);
        */
        /*
        Error:(17, 21) java: incompatible types: ocp8.ch1.Hippo cannot be converted to ocp8.ch1.Elephant
        Type are not in the same hierarchy does not compile
        */

        // Compiler allows instanceof to be applied to any interface. Since in future class can add its implementation.
        // Compiler check only applies when instanceof called on a class. When checking an object is an instanceof interface
        // Java waits until runtime to do the check. The reason is that subclass could implement the interface and the
        // compiler could not know about that.
        assertFalse(hippo instanceof Serializable);
        assertFalse(hippo instanceof MotherHippo);
    }

    @Test
    public void testObject() {
        assertTrue(hippo instanceof Object);
    }

    @Test
    public void testNull() {
        /*
        Everything extends Object. The only case when instanceof Object return false is null reference.
         */
        HeavyAnimal hippo2 = null;
        assertFalse(hippo2 instanceof Object);
        assertTrue(hippo2 == null);
    }
}