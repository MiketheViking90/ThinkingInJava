package generics;

import java.util.Iterator;
import java.util.Random;

import generics.abst.Generator;
import generics.domain.Americano;
import generics.domain.Cappuccino;
import generics.domain.Coffee;
import generics.domain.Latte;
import generics.domain.Mocha;
import lombok.Getter;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private static Random rand = new Random(47);

    private Class<?>[] types = { Americano.class, Cappuccino.class, Latte.class, Mocha.class };
    @Getter private int size = 0;


    public CoffeeGenerator() {}

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffee generate() {
        int index = rand.nextInt(types.length);

        try {
            return (Coffee) types[index].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class CoffeeIterator implements Iterator<Coffee> {

        int count = size;
        @Override
        public boolean hasNext() {
            return count >= 0;
        }

        @Override
        public Coffee next() {
            count--;
            return generate();
        }

    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.generate());
        }

        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
