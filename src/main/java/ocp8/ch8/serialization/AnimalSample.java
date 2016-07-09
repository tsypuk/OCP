package ocp8.ch8.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by rtsy on 28.02.2016.
 */
public class AnimalSample {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        Animal animal = new Animal();
//
        Animal animal2 = new Animal("Lion", 22, 'L');
        animal2.setWeight(90);
        checkAnimal(animal);
        checkAnimal(animal2);

        Animal animal3 = (Animal) readAnimal(new File("Animal"));
        System.out.println(animal3);
    }

    private static void checkAnimal(Animal animal)
            throws IOException, ClassNotFoundException {
        File file = writeAnimal(animal);
        animal = readAnimal(file);
        System.out.println(animal);
    }

    private static Animal readAnimal(File file)
            throws IOException, ClassNotFoundException {
        Animal animal;
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        animal = (Animal)in.readObject();
        return animal;
    }

    private static File writeAnimal(Animal animal)
            throws IOException {
        System.out.println(animal);
        File file = new File("Animal");
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        out.writeObject(animal);
        out.close();
        return file;
    }
}
