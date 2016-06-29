package ocp8.ch5;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by roman.tsypuk on 6/29/16.
 */
public class DatesTest {
    @Test
    public void testPeriod() {
        assertEquals("P1D", Period.ofDays(1).toString());
        assertEquals("P1M", Period.ofMonths(1).toString());
        assertEquals("P1Y", Period.ofYears(1).toString());
        // No chain is supported
        assertEquals("P1Y", Period.ofDays(5).ofYears(1).toString());
    }

    @Test
    public void testDuration() {
        assertEquals("PT24H", Duration.ofDays(1).toString());
        assertEquals("PT25M", Duration.ofMinutes(25).toString());
        assertEquals("PT43S", Duration.ofSeconds(43).toString());
        assertEquals("PT0.001S", Duration.ofMillis(1).toString());
        // No chaining is supported
        assertEquals("PT0.001S", Duration.ofDays(5).ofMillis(1).toString());
    }

    @Test
    public void testChrono() {
        assertEquals("PT30M", Duration.of(30, ChronoUnit.MINUTES).toString());
    }

    /**
     * Spring Forward time 1-00am 1-59am -> 2-00am 3-00am -> 3-00am 4-00am
     * 1-00am 1-59am -> 3-00am 4-00am
     * There is no 2-00am 3-00am in 13 March
     * 2016-03-13T01:30-05:00[US/Eastern]
     * +1 hour
     * ----------------
     * 2016-03-13T03:30-04:00[US/Eastern]
     */
    @Test
    public void testSpringForward() {
        ZonedDateTime springForward = ZonedDateTime.of(LocalDate.of(2016, Month.MARCH, 13), LocalTime.of(1, 30), ZoneId.of("US/Eastern"));
        ZonedDateTime afterForward = springForward.plusHours(1);
        assertEquals("2016-03-13T03:30-04:00[US/Eastern]", afterForward.toString());
    }

    /**
     * Autumn FallBack time 1-00am 1-59am -> 2-00am 3-00am -> 3-00am 4-00am
     * 1-00am 1-59am -> 1-00am 1-59am -> 2-00am 4-00am
     * We have double 1-00am 1-59am in 6 November
     * 2016-11-06T01:30-04:00[US/Eastern]
     * +1 hour
     * ----------------
     * 2016-11-06T01:30-05:00[US/Eastern]
     */
    @Test
    public void testFallbackInFall() {
        ZonedDateTime springForward = ZonedDateTime.of(LocalDate.of(2016, Month.NOVEMBER, 6), LocalTime.of(1, 30), ZoneId.of("US/Eastern"));
        ZonedDateTime afterForward = springForward.plusHours(1);
        assertEquals("2016-11-06T01:30-05:00[US/Eastern]", afterForward.toString());

    }

    /**
     * Time Changes in Kyiv Over the Years
     * 2016	Sun, 27 Mar, 03:00	EET → EEST	+1 hour (DST start) | Probable date	UTC+3h
     */
    @Test
    public void testSpringForwardUkraine() {
        ZonedDateTime springForward = ZonedDateTime.of(LocalDate.of(2016, Month.MARCH, 27), LocalTime.of(2, 30), ZoneId.of("Europe/Kiev"));
        ZonedDateTime afterForward = springForward.plusHours(1);
        assertEquals("2016-03-27T04:30+03:00[Europe/Kiev]", afterForward.toString());
    }

    /**
     * Time Changes in Kyiv Over the Years
     * 2016 Sun, 30 Oct, 04:00	EEST → EET	-1 hour (DST end) | Preliminary date	UTC+2h
     */
    @Test
    public void testFallbackInFallUkraine() {
        ZonedDateTime springForward = ZonedDateTime.of(LocalDate.of(2016, Month.OCTOBER, 30), LocalTime.of(3, 30), ZoneId.of("Europe/Kiev"));
        System.out.println(springForward);
        ZonedDateTime afterForward = springForward.plusHours(1);
        assertEquals("2016-10-30T03:30+02:00[Europe/Kiev]", afterForward.toString());
    }
}