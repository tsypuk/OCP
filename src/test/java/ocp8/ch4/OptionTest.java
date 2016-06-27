package ocp8.ch4;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 6/27/16.
 */
public class OptionTest {

    @Test
    public void testOption() {
        Optional<Double> result = average(10);
        assertTrue(result.isPresent());
        assertEquals(10D, result.get(), 0.01);
    }

    @Test
    public void testEmptyOptionOrElse() {
        Optional<Double> result = average();
        assertTrue(!result.isPresent());
        assertEquals(20D, result.orElse(20D), 0.01);
    }

    @Test
    public void testEmptyOptionOrElseGet() {
        Optional<Double> result = average();
        assertTrue(!result.isPresent());
        assertTrue(result.orElseGet(Math::random) > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyOptionOrElseThrow() {
        Optional<Double> result = average();
        assertTrue(!result.isPresent());
        assertTrue(result.orElseThrow(() -> new IllegalArgumentException("Hi")) > 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyOptionException() {
        Optional<Double> result = average();
        assertEquals(10, result.get(), 1);
    }

    private Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return Optional.ofNullable((double) sum / scores.length);
    }
}