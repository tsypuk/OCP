package ocp8.ch1;

import java.util.ArrayList;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
public class Browsers {
    static class Browser {
        public void go() {
            System.out.println("Inside Browser");
        }
    }

    static class Firefox extends Browser {
        @Override
        public void go() {
            System.out.println("Insode FireFox");
        }
    }

    static class IE extends Browser {
        @Override
        public void go() {
            System.out.println("Inside IE");
        }
    }

    public static void main(String[] args) {
        Browser firefox = new Firefox();
        IE e = (IE) firefox;
        e.go();
/*

        Error:(33, 29) java: incompatible types: ocp8.ch1.Browsers.Browser cannot be converted to java.lang.String
        String l = (String) firefox;
*/

    }
}
