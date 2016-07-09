package ocp8.ch7;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 7/2/16.
 */
public class ExecutorTest {

    @Test(expected = RejectedExecutionException.class)
    public void testShutdownRejected() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        assertFalse(executor.isShutdown());
        assertFalse(executor.isTerminated());
        executor.execute(() ->
                System.out.println("Test lambda."));
        assertFalse(executor.isShutdown());
        assertFalse(executor.isTerminated());
        executor.shutdown();
        assertTrue(executor.isShutdown());
        assertFalse(executor.isTerminated());

        executor.submit(() ->
                System.out.println("Could not happen.")
        );
    }

    @Test
    public void testShutdown() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() ->
                System.out.println("Test lambda.")
        );
        executor.shutdown();
        Thread.sleep(1000);
        assertTrue(executor.isShutdown());
        assertTrue(executor.isTerminated());
    }

}