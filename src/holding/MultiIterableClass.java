package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MultiIterableClass extends IterableClass {

    public Iterable<String> reverseIterable() {
        return new Iterable<String>() {

            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int curIndex = words.length - 1;

                    @Override
                    public boolean hasNext() {
                        return curIndex > -1;
                    }

                    @Override
                    public String next() {
                        return words[curIndex--];
                    }
                };
            }

        };
    }

    public Iterable<String> randomIterable() {
        return new Iterable<String>() {

            @Override
            public Iterator<String> iterator() {
                List<String> wordsAsList = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(wordsAsList);

                return wordsAsList.iterator();
            }

        };
    }

    public static void main(String[] args) {
        MultiIterableClass iterable = new MultiIterableClass();
        Iterable<String> revIb = iterable.reverseIterable();
        Iterable<String> randIb = iterable.randomIterable();

        for (String s : revIb) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : randIb) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : iterable) {
            System.out.print(s + " ");
        }
    }
}
