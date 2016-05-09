package ocp8.ch1;

import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

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
        Error:(17, 21) java: incompatible types: ocp8.ch1.Hippo cannot be converted to ocp8.ch1.Elephant
        Type are not in the same hierarchy does not compile
        */

        // Compiler allows instanceof to be applied to any interface. Since in future class can add its implementation.
        assertFalse(hippo instanceof Serializable);
        assertFalse(hippo instanceof MotherHippo);
    }

    @Test
    public void testObject() {
        assertTrue(hippo instanceof Object);
    }

    @Test
    public void testNull() {
        HeavyAnimal hippo2 = null;
        assertFalse(hippo2 instanceof Object);
    }
}