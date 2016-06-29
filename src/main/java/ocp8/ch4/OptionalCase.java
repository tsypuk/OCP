package ocp8.ch4;

import java.util.Optional;

/**
 * Created by roman.tsypuk on 6/28/16.
 */
public class OptionalCase {
    public static void main(String[] args) {
        threeDigits(Optional.empty());
        threeDigits(Optional.of(123));
        threeDigits(Optional.of(1234));
    }
    public static void threeDigits(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(str -> str.length() == 3)
                .ifPresent(System.out::println);
    }
}
