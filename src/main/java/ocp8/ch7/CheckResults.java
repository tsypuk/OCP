package ocp8.ch7;

/**
 * Created by rtsy on 11.02.2016.
 */
public class CheckResults {
    private static int counter = 0;

    public static void main(String[] args)
            throws InterruptedException {
        new Thread( () -> {
            for (int i = 0; i < 500; i++) {
                CheckResults.counter++;
            }
        }
        ).start();

        while (CheckResults.counter < 100) {
            System.out.println("Not reached.");
            Thread.sleep(1000);
        }
        System.out.println("Reached");
    }
}
