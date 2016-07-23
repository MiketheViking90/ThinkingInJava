package generics;

import generics.domain.Amphibian;
import generics.domain.Vehicle;

public class TupleTest {

    static Tuple<String, Integer> foo() {
        return new Tuple<String, Integer>("hi", 47);
    }

    static Triple<Amphibian, String, Integer> goo() {
        return new Triple<Amphibian, String, Integer>(new Amphibian(), "hi", 47);
    }

    static Quadruple<Vehicle, Amphibian, String, Integer> hoo() {
        return new Quadruple<Vehicle, Amphibian, String, Integer>
            (new Vehicle(), new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        Tuple<String, Integer> tuple = foo();
        System.out.println(tuple);

        System.out.println(goo());
        System.out.println(hoo());
    }
}
