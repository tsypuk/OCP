package hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTestTest {

    @Test
    public void testHashFunc()
            throws Exception {

        assertEquals(0, HashTest.hashFunc(1));
        assertEquals(1, HashTest.hashFunc(2));
        assertEquals(3, HashTest.hashFunc(3));
        assertEquals(15, HashTest.hashFunc(9));
    }


}