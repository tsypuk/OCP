package ocp8.ch8.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by rtsy on 28.02.2016.
 */
public class ObjectWriter {

    public static void main(String[] args)
            throws IOException {
        Animal animal = new Animal(22, "Lion", 'c');
        File file = new File("animal.dump");
        writeToFile(animal, file);
        Animal deserializedAnimal = readFromFile(file);
        System.out.println(getSerialVersionUID(file));
    }

    private static String getSerialVersionUID(File file)
            throws IOException {
        InputStream in = new FileInputStream(file);
        in.skip(42);
        String hex = Integer.toHexString(in.read()) + Integer.toHexString(in.read());
        return Integer.parseInt(hex, 16) + "L";
    }

    private static Animal readFromFile(File file)
            throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object obj = in.readObject();
            if (obj instanceof Animal) {
                return (Animal) obj;
//                System.out.println(animalDesirialized);
            }
        } catch (ClassNotFoundException | InvalidClassException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void writeToFile(Animal animal, File file)
            throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeObject(animal);
        }
    }

    static class Animal implements Serializable {
        private static final long serialVersionUID = 332L;
        private int age;
        private String name;
        private char type;

        public Animal(int age, String name, char type) {
            this.age = age;
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
