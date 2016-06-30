package ocp8.ch6;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 6/30/16.
 */
public class TryWithResourcesTest {

    @Test
    public void testSupressed() {
        try (TurkeyCageRuntimeException turkey = new TurkeyCageRuntimeException()) {
            throw new RuntimeException("turkey ran off");
        } catch (RuntimeException ex) {
            System.out.println("caught: " + ex.getMessage());
            assertEquals(RuntimeException.class, ex.getClass());
            assertTrue(ex.getSuppressed().length == 1);
            for (Throwable t : ex.getSuppressed()) {
                assertEquals(IllegalStateException.class, t.getClass());
            }
        }
    }

    @Test
    public void twoSupressed() {
        try (TurkeyCageRuntimeException turkey1 = new TurkeyCageRuntimeException();
             TurkeyCageRuntimeException turkey2 = new TurkeyCageRuntimeException();
        ) {
            throw new IllegalStateException("turkey ran off");
        } catch (IllegalStateException ex) {
            assertEquals(IllegalStateException.class, ex.getClass());
            /*
               We have 2 resources. Since Java closes resources in the reverse order from which it created them,
               the turkey2 resourse is closed first. It throws exception, than turkey1 throws exception and adds it
               to suppressed of previous. The size of suppressed is 2 in this case.
             */
            assertTrue(ex.getSuppressed().length == 2);
            for (Throwable t : ex.getSuppressed()) {
                assertEquals(IllegalStateException.class, t.getClass());
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupressedFinally() {
        try (TurkeyCageRuntimeException turkey = new TurkeyCageRuntimeException()) {
            throw new RuntimeException("turkey ran off");
        } catch (RuntimeException ex) {
            System.out.println("caught: " + ex.getMessage());
            assertEquals(RuntimeException.class, ex.getClass());
            for (Throwable t : ex.getSuppressed()) {
                assertEquals(IllegalStateException.class, t.getClass());
            }
        } finally {
            //Finally is always executed. Previous exception and supressed are lost.
            throw new IllegalArgumentException();
        }
    }
}