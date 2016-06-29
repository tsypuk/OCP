package ocp8.ch5;

import java.time.*;
import java.util.Set;

/**
 * Created by roman.tsypuk on 6/29/16.
 */
public class Dates {
    public static void main(String[] args) {
        createLocal();
        currentZone();
        euroZone();

        localDateException();

    }

    private static void localDateException() {
        try {
            LocalDate.of(2010, 13, 10); //Invalid value for MonthOfYear (valid values 1 - 12): 13
        } catch (DateTimeException ex) {
            System.out.println(ex);
        }
        LocalDate.of(-1000, 11, 10);
        try {
            LocalDate.of(2016, 11, 40); //Invalid value for DayOfMonth (valid values 1 - 28/31): 40
        } catch (DateTimeException ex) {
            System.out.println(ex);
        }
    }

    private static void currentZone() {
        //        ZoneId zoneId = ZoneId.systemDefault();
//        System.out.println(zoneId);
    }

    private static void euroZone() {
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zone -> zone.toLowerCase().contains("europe")) //|| zone.toLowerCase().contains("ukr"))
                .sorted()
                .forEach(System.out::println);
    }

    private static void createLocal() {
        LocalDate date1 = LocalDate.of(2016, Month.JUNE, 29);
        System.out.println(date1);

        LocalTime time1 = LocalTime.of(12, 29, 30, 200);
        System.out.println(time1);

        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);
        System.out.println(dateTime1);
    }
}
