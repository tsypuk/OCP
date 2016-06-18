package ocp8.ch1;

import org.junit.Test;

import static org.junit.Assert.*;
import static ocp8.ch1.Season.*;

public class SeasonTest {

    @Test
    public void getEnum() {
        Season season = WINTER;
        assertTrue(season == Season.WINTER);
    }

    @Test
    public void testValues() {
        for (Season season : Season.values()) {
            System.out.println(season.name() + " :: " + season.ordinal());
            switch (season) {
                case WINTER:
                    System.out.println("winter");
                    break;
                case SPRING:
                    break;
                case SUMMER:
                    break;
                case FALL:
                    break;
            }
        }
        assertFalse(SUMMER.hashCode() == WINTER.hashCode());
    }
}