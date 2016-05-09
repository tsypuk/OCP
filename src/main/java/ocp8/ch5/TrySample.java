package ocp8.ch5;

/**
 * Created by rtsy on 06.03.2016.
 */
public class TrySample {

    public static void main(String[] args) {
        System.out.println(getTry());
    }

    /**
     * Warning:(18, 9) java: finally clause cannot complete normally
     */
    private static boolean getTry() {
        try {
            return true;
        }
        finally {
            return false;
        }
    }
}
