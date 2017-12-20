package generics;

import java.util.Iterator;

import generics.abst.Generator;
import lombok.Getter;

public class FibonnacciGenerator implements Generator<Integer>, Iterable<Integer> {

    private final int size;
    @Getter
    private int[] fibs;
    private Iterator<Integer> fibIt;

    public FibonnacciGenerator(int sz) {
        if (sz < 2) {
            throw new IllegalArgumentException();
        }
        size = sz;
        calculateFibs();
        fibIt = new FibonnacciIterator(fibs);
    }

    @Override
    public Integer generate() {
        return fibs[size - 1];
    }

    @Override
    public Iterator<Integer> iterator() {
        return fibIt;
    }

    private void calculateFibs() {
        fibs = new int[size];
        fibs[0] = 1;
        fibs[1] = 1;

        for (int i = 2; i < size; i++) {
            fibs[i] = (fibs[i - 1] + fibs[i - 2]);
        }
    }

    public static void main(String[] args) {
        FibonnacciGenerator fibGen = new FibonnacciGenerator(11);
        fibGen.generate();

        System.out.println();

        for (int i : fibGen) {
            System.out.println(i);
        }
    }

}
