package ocp8.ch2;

import org.junit.Test;

/**
 * Created by roman.tsypuk on 6/19/16.
 */
public class CastingTest {

    @Test
    public void testNormalCasting() {
        AnimalParent elepahnt = new Eliphant();
        BirdParent kalibry = new Kalibry();
    }

    @Test
    public void testImplicitCasting() {
        Eliphant elepahnt = new Eliphant();
        AnimalParent animalParent = elepahnt;
        Kalibry kalibry = new Kalibry();
        BirdParent birdParent = kalibry;
    }

    @Test
    public void testExplicitCasting() {
        Eliphant elepahnt = new Eliphant();
        AnimalParent animalParent = elepahnt;
        Eliphant eliphant2 = (Eliphant) animalParent;
    }

    @Test(expected = ClassCastException.class)
    public void testClassCastException() {
        AnimalParent parent = new AnimalParent();
        Eliphant eliphant = (Eliphant) parent;
    }

/*
    Error:(42, 37) java: incompatible types: ocp8.ch2.AnimalParent cannot be converted to ocp8.ch2.Kalibry
    @Test
    public void testCompilationFails() {
        AnimalParent parent = new AnimalParent();
        Kalibry kalibry = (Kalibry) parent;
    }
*/
}