package generics.exercises;

import java.util.Iterator;

import generics.domain.Coffee;

public class CoffeeIterable implements Iterable<Coffee> {

    private int size;

    public CoffeeIterable(int sz) {
        size = sz;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            int cnt = size;
            @Override
            public boolean hasNext() {
                return cnt >= 0;
            }

            @Override
            public Coffee next() {
                cnt--;
                return new Coffee();
            }

        };
    }

    public static void main(String[] args) {
        for (Coffee c : new CoffeeIterable(5)) {
            System.out.println(c);
        }
    }
}
