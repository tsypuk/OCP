package ocp8.ch1;

/**
 * Created by rtsy on 23.01.2016.
 *  HeavyAnimal
 *      |       |
 *      Hippo   Elephant
 *         |
 *         |
 * Mother  |
 * |       |
 * MotherHippo
 */
public class InstanceOf {

}
class HeavyAnimal {}
class Hippo extends HeavyAnimal {}
class Elephant extends HeavyAnimal {}
interface Mother {}
class MotherHippo extends Hippo implements Mother {}
