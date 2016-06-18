package ocp8.ch1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static ocp8.ch1.VirtualMethod.feedAnimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * On the OCP Oracle now calls virtual methods in the objectives. Java invoked at the actual type
 * of animal at runtime and called feed on that. The decision is happen at runtime.
 */
public class VirtualMethodTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testVirtualLion() {
        Animal lion = new Lion();
        feedAnimal(lion);
        assertEquals("Lion eats meat.\n", outContent.toString());
    }

    @Test
    public void testVirtualBird() {
        Animal bird = new Bird();
        feedAnimal(bird);
        assertEquals("Bird eats seed.\n", outContent.toString());
    }

    @Test
    public void testInstanceVariables() {
        Animal lion = new Lion();
        lion.printName();
        assertEquals("???\n", outContent.toString());
        assertEquals("???", lion.name);
        assertEquals("Lion", ((Lion) lion).name);
    }

    @Test
    public void testInstanceVariables2() {
        Animal lion = new Lion();
        (lion).printName();
        assertFalse("Lion".equals(outContent.toString()));
    }

    @Test
    public void testOverriddenVirtual() {
        Animal lion = new Lion();
        lion.play();
        //The overriden method will be called all time. Even thought the call is from the Animal
        assertEquals("toss in meat\n", outContent.toString());
    }

    @Test
    public void testOverridenVirtual2() {
        Animal lion = new Cow();
        lion.play();
        assertEquals("pet animal\n", outContent.toString());
    }
}