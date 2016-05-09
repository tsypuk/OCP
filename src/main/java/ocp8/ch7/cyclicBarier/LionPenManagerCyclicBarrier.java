package ocp8.ch7.cyclicBarier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by rtsy on 21.02.2016.
 */
public class LionPenManagerCyclicBarrier {
    private void removeAnimals() {
        System.out.println("Removing animals.");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen.");
    }

    private void addAnimals() {
        System.out.println("Adding animals.");
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManagerCyclicBarrier manager = new LionPenManagerCyclicBarrier();

            CyclicBarrier animalsRemoved = new CyclicBarrier(4, () -> System.out.println("*** Animals removed !"));
            CyclicBarrier penCleaned = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned !"));

            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTask(animalsRemoved, penCleaned));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}