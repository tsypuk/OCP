package ocp8.ch2;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
public class FindMatchingAnimals {
    private static void print(Animal animal, CheckTraitable check) {
        if (check.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish", false, true), animal -> animal.canSwim());
        print(new Animal("kangaroo", true, false), animal -> animal.canHop());
    }
}