package ocp7.chapter8;

/**
 * Created by rtsy on 14.10.2015.
 */
public class StringFormats {
    public static void main(String[] args) {
        System.out.printf("%2$d %1$d \n", 122, 233);
        System.out.printf(">%1$,11d< \n", 12345678);
        System.out.printf(">%1$2s< \n", 2.4403);
        System.out.printf(">%1$,.2f< \n", 2354548.235);
    }
}