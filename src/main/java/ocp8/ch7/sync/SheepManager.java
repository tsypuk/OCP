package ocp8.ch7.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by rtsy on 13.02.2016.
 */
public class SheepManager {
    private AtomicInteger sheepCount = new AtomicInteger(0);

    private synchronized void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
             service = Executors.newFixedThreadPool(20);
            SheepManager sheepManager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> sheepManager.incrementAndReport());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
