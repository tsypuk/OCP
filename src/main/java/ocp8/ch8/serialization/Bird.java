package ocp8.ch8.serialization;

import java.io.Serializable;

/**
 * Created by roman.tsypuk on 7/9/16.
 */
public class Bird implements Serializable {
    private static final long serialVersionUID = 22L;
    transient String name;

    public Bird() {
        this.name = "Bird";
    }
}