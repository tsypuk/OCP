package ocp8.ch7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by rtsy on 11.02.2016.
 * Results are guaranteed to be executed in the order in which they are added to the executor services.
 */
public class ZooExecutor {

    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");

            service.execute(() -> System.out.println("zoo"));
            service.execute(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            service.execute(() -> System.out.println("zoo end"));

            System.out.println("is shutdown: " + service.isShutdown());
            System.out.println("is terminated: " + service.isTerminated());
            System.out.println("end");
        } finally {
            if (service != null) {
                service.shutdown();
                try {
                    service.execute(() -> System.out.println("rejected"));
                } catch (RejectedExecutionException ex) {
                    System.out.println("Rejects new tasks");
                }
                System.out.println("is shutdown: " + service.isShutdown());
                System.out.println("is terminated: " + service.isTerminated());


                Thread.sleep(10_000);
                System.out.println("is shutdown: " + service.isShutdown());
                System.out.println("is terminated: " + service.isTerminated());

            }
        }
    }
}