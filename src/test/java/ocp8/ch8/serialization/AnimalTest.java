package ocp8.ch8.serialization;

import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by roman.tsypuk on 7/9/16.
 */
public class AnimalTest {

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        Animal animal = new Animal("rabbit", 3, 'P');
        animal.setWeight(10);
        animal.setObj("This is object");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FILE_SERIAL_dump"));
        out.writeObject(animal);

        animal.setWeight(100);
        animal.setName("tiger");

        ObjectInput in = new ObjectInputStream(new FileInputStream("FILE_SERIAL_dump"));
        Animal animalDeserial = (Animal) in.readObject();
        assertNotEquals(animal, animalDeserial);
        // Age is transient field that is initialized with default value int = 0
        assertEquals(0, animalDeserial.getAge());
        // Weigth field is static and it is not serialized - it is common for all classes in JVM
        assertEquals(100, animalDeserial.getWeight());
        assertEquals("rabbit", animalDeserial.getName());
        assertNotNull(animalDeserial.getObj());
        assertNotNull(animalDeserial.getList());
    }

    @Test
    public void testObject() {
        Object o = new Object();
        assertFalse(o instanceof Serializable);
    }

    @Test
    public void testConstructor() throws IOException, ClassNotFoundException {


        Hawk hawk = new Hawk();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("BIRD.dump"));
        out.writeObject(hawk);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("BIRD.dump"));
        Hawk bird = (Hawk) inputStream.readObject();

        assertNull(bird.name);
    }

}