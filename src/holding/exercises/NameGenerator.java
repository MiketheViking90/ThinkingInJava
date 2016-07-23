package holding.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class NameGenerator {

    private static final String[] NAMES = {"Spike", "Jet", "Faye", "Ed", "Ein", "Viscious", "Julia", "Vincent"};

    private int index;

    public NameGenerator() {
        index = 0;
    }

    public String next() {
        if (index == NAMES.length) {
            index = 0;
        }

        return NAMES[index++];
    }

    public static void main(String[] args) {
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));
        print(fill(new HashSet<String>()));
        print(fill(new LinkedHashSet<String>()));
        print(fill(new TreeSet<String>()));
    }

    private static Collection<String> fill(Collection<String> coll) {
        NameGenerator gen = new NameGenerator();

        for (int i = 0; i < 10; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    private static void print(Collection<String> coll) {
        System.out.println(coll);
    }
}
