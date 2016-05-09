package ocp8.ch8.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by rtsy on 28.02.2016.
 */
public class SingleToneHack {

    private static void showHashCode(Object object) {
        System.out.println(object.hashCode());
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        SingleTone singleTone = SingleTone.getInstance();
        int hashCode = singleTone.hashCode();
        showHashCode(singleTone);

        SingleTone singleTone2 = SingleTone.getInstance();
        int hashCode2 = singleTone2.hashCode();
        showHashCode(singleTone2);

        if (hashCode != hashCode2) {
            throw new IllegalStateException("More then 2 singletone instances in one JVM.");
        }

        File file = new File("SingleTone.dump");
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        out.writeObject(singleTone);
        out.flush();
        out.close();

        // This is possible only if our singletone class implements Serializable
        ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        SingleTone singleTone3 = (SingleTone) input.readObject();
        showHashCode(singleTone3);

        input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        SingleTone singleTone4 = (SingleTone) input.readObject();
        showHashCode(singleTone4);
    }
}
