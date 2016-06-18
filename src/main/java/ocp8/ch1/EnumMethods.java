package ocp8.ch1;

/**
 * Created by roman.tsypuk on 6/6/16.
 */
public enum  EnumMethods {

    CODING {
        @Override
        String action() {
            return "I'm codding";
        }
    }, REVIEW {
        @Override
        String action() {
            return "I'm doing code review";
        }
    }, PROMOTE {
        @Override
        String action() {
            return "I promote my changes";
        }
    };

    abstract String action();
}