package arrays.domain;

public class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}
