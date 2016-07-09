package ocp8.ch7;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by rtsy on 11.02.2016.
 */
public class FutureService {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException, TimeoutException {
//        createSingleExecutor();
        createSchedule();
//        createFixedRate();

    }

    private static void createSingleExecutor()
            throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            for (int i = 0; i < 500; i++) {
                System.out.println("Running");
            }
        };
        Future<?> future = service.submit(runnable);
        future.get(10, TimeUnit.SECONDS);

        System.out.println(future.isDone());
        System.out.println("Reached!");

        Future<Integer> future2 = service.submit(
                () -> {
                    Thread.sleep(5_000);
                    return 30 + 11;
                }
        );
        System.out.println("Future=" + future2.get());
        System.out.println("Hello");

        if (service != null) {
            service.shutdown();
        }
    }

    private static void createFixedRate() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> System.out.println(LocalDateTime.now());
        // every 1 second.
        // start delay 10 seconds.
        service.scheduleAtFixedRate(task, 10, 1, TimeUnit.SECONDS);
    }

    private static void createSchedule()
            throws ExecutionException, InterruptedException {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        Runnable task1 = () -> System.out.println("Hello");
        Callable<String> task2 = () -> "Monkey";

        Future result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        System.out.println("result1" + result1.get());
        Future<String> result2 = service.schedule(task2, 15, TimeUnit.SECONDS);
        System.out.println("result2");
        service.shutdown();
        System.out.println(" result2=" + result2.get());
    }
}