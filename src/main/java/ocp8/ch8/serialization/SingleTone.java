package ocp8.ch8.serialization;

import java.io.Serializable;

/**
 * Created by rtsy on 28.02.2016.
 */
public class SingleTone implements Serializable{
    private static SingleTone instance;

    private SingleTone() {
        if (instance != null) {
            throw new IllegalStateException("Can not init");
        }
    }

    public static SingleTone getInstance() {
        if (instance == null) {
            synchronized (SingleTone.class) {
                if (instance == null) {
                    instance = new SingleTone();
                }
            }
        }
        return instance;
    }
}
