package ocp8.ch7.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rtsy on 22.02.2016.
 */

class Food {
}

class Water {
}

public class Fox {

    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println("Eat food.");
            move();
            synchronized (water) {
                System.out.println("Drink water");
            }
        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println("Drink water");
            move();
            synchronized (food) {
                System.out.println("Eat food");
            }
        }
    }

    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fox foxy = new Fox();
        Fox tails = new Fox();

        Food food = new Food();
        Water water = new Water();

        ExecutorService service = null;

        try {
            service = Executors.newScheduledThreadPool(10);
//            Dead lock operations:
//            service.submit(() -> foxy.eatAndDrink(food, water));
//            service.submit(() -> tails.drinkAndEat(food, water));

            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.eatAndDrink(food, water));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

    }
}
