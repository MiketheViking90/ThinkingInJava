package generics;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T t) {
        storage.add(t);
    }

    public T select() {
        int index = rand.nextInt(storage.size());
        return storage.get(index);
    }

    public static void main(String[] args) {
        RandomList<String> rl = new RandomList<>();

        for (String s : "the quick brown fox jumped over the lazy dog".split(" ")) {
            rl.add(s);
        }

        for (int i = 0; i < 11; i++) {
            System.out.println(rl.select());
        }
    }
}
