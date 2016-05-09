package ocp7.chapter7;

/**
 * Created by rtsy on 14.10.2015.
 */
public class AutoClosableTask {
    public static void main(String[] args) {
        /*
        resources are free backward there declaration
        */
        try (A a = new A(); B b = new B()) {
            System.out.println("Try");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }

    static class A implements AutoCloseable {

        @Override
        public void close()
                throws Exception {
            System.out.println("close A.");
        }
    }

    static class B implements AutoCloseable {
        @Override
        public void close()
                throws Exception {
            System.out.println("close B.");
        }
    }
}
