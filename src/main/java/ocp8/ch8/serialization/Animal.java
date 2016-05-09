package ocp8.ch8.serialization;

import java.io.Serializable;

/**
 * Created by rtsy on 28.02.2016.
 */
public class Animal implements Serializable{
    private static final long serialVersionUID = 2L;

    // Transient fields do not written to disk. When deserialize they are init by default data type values
    // String null, int 0...
    // static transient field is common for all instances and it would have the value of the las Object was in JVM.
    // In case that there are no instances of this class in JVM memory then static field will be init by value 'C'.
    // No constructors call. No default initialization blocks.

    private transient String name;
    private transient int age = 10;
    private static transient char type = 'C';
    private int weight = 20;

    {this.age = 14;}

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public Animal() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", weight=" + weight +
                '}';
    }
}
