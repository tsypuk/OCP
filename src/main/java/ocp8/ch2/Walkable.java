package ocp8.ch2;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
@FunctionalInterface
public interface Walkable {
    boolean isQuadrupped();
/*
    Error:(6, 1) java: Unexpected @FunctionalInterface annotation
    ocp8.ch2.Walkable is not a functional interface
    multiple non-overriding abstract methods found in interface ocp8.ch2.Walkable
    abstract double getMaxSpeed();
*/
}