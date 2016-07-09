package ocp8.ch8.serialization;

import java.io.Serializable;

/**
 * Created by roman.tsypuk on 7/9/16.
 */
public class Hawk extends Bird implements Serializable {

    public Hawk() {
        this.name = "Hawk";
    }
}