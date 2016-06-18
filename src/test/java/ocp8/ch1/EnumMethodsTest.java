package ocp8.ch1;

import static ocp8.ch1.EnumMethods.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 6/6/16.
 */
public class EnumMethodsTest {

    @Test
    public void testAction() throws Exception {
        assertEquals(CODING.action(), "I'm codding");
        assertEquals(PROMOTE.action(), "I promote my changes");
    }
}