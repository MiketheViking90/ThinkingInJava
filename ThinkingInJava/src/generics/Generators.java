package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import generics.abst.Generator;
import generics.domain.Coffee;

public class Generators {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            T val = gen.generate();
            coll.add(val);
        }
        return coll;
    }

    public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            T val = gen.generate();
            coll.add(val);
        }
        return coll;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            T val = gen.generate();
            coll.add(val);
        }
        return coll;
    }

    public static void main(String[] args) {
        List<Coffee> coffeeList = fill(
                new ArrayList<Coffee>(),
                new CoffeeGenerator(),
                10);

        System.out.println(coffeeList);

        List<Integer> intList = fill(new LinkedList<Integer>(),
                new FibonnacciGenerator(4),
                3);
        System.out.println(intList);
    }
}
