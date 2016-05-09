package ocp8.ch1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToStringTest {

    @Test
    public void testEqual() {
        ToString o1 = new ToString("name1", "address1");
        ToString o2 = new ToString("name1", "address2");
        assertFalse(o1.equals(o2));

        ToString o3 = new ToString("name1", "address1");
        assertEquals(o1, o3);
    }

    @Test
    public void testReflexive() {
        ToString x = new ToString("namex", "addressx");
        assertTrue(x.equals(x));
    }

    @Test
    public void testSymmetric() {
        ToString x = new ToString("namex", "addressy");
        ToString y = new ToString("namex", "addressy");
        assertTrue(x.equals(y));
        assertTrue(y.equals(x));
    }

    @Test
    public void testTransitive() {
        ToString x = new ToString("namex", "addressx");
        ToString y = new ToString("namex", "addressx");
        ToString z = new ToString("namex", "addressx");
        assertTrue(x.equals(y));
        assertTrue(y.equals(z));
        assertTrue(x.equals(z));
    }

    @Test
    public void testConsistent() {
        ToString x = new ToString("namex", "addressy");
        ToString y = new ToString("namex", "addressy");
        for (int i = 0; i < 10; i ++) {
            assertTrue(x.equals(y));
        }
    }

    @Test
    public void testNotNull() {
        ToString x = new ToString("namex", "addressy");
        assertFalse(x.equals(null));
    }
}