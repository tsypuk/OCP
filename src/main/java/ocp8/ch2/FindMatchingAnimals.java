package ocp8.ch2;

import java.util.function.Predicate;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
public class FindMatchingAnimals {
    private static void print(Animal animal, CheckTraitable check) {
        if (check.test(animal)) {
            System.out.println(animal);
        }
    }

    private static void printWithPredicate(Animal animal, Predicate<Animal> check) {
        if (check.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), animal -> animal.canSwim());
        print(new Animal("kangaroo", true, false), animal -> animal.canHop());

        printWithPredicate(new Animal("fish", false, true), animal -> animal.canSwim());
        printWithPredicate(new Animal("kangaroo", true, false), animal -> animal.canHop());

    }
}