package ocp8.ch1;

import org.junit.Test;
import static ocp8.ch1.EnumString.*;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 6/6/16.
 * On first call to enum, java creates all its enum's values.
 */
public class EnumStringTest {

    @Test
    public void testToString403() throws Exception {
        EnumString str = NOT_FOUND;
        assertEquals("" + str, "403");
    }

    @Test
    public void testToString200() throws Exception {
        EnumString str = OK;
        assertEquals("" + str, "200");
    }

    /**
     * The first time we use the ENUM java creates all its values.
     * @throws Exception
     */
    @Test
    public void testToStringCheckCreate() throws Exception {
        EnumString str1 = OK;
    }
}