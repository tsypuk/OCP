package ocp8.ch1;

/**
 * Created by rtsy on 23.01.2016.
 */

/**
 * Virtual method is regular non-static method. Java looks for an overriden method rather
 * than necessarily using the one in the class that the compiler says we have.
 */
public class VirtualMethod {
    static void feedAnimal(Animal animal) {
        animal.feed();
    }
}

abstract class Animal {
    String name = "???";
    public abstract void feed();

    public void printName() {
        System.out.println(name);
    }

    public void careFor() {
        play();
    }

    public void play() {
        System.out.println("pet animal");
    }
}

class Cow extends Animal {

    String name = "Cow";

    @Override
    public void feed() {
        addHay();
    }

    private void addHay() {
        System.out.println("Cow eats hay.");
    }
}

class Bird extends Animal {

    String name = "Bird";
    @Override
    public void feed() {
        addSeed();
    }

    private void addSeed() {
        System.out.println("Bird eats seed.");
    }
}

class Lion extends Animal {

    String name = "Lion";

    @Override
    public void feed() {
        addMeat();
    }

    private void addMeat() {
        System.out.println("Lion eats meat.");
    }

    @Override
    public void play() {
        System.out.println("toss in meat");
    }
}
