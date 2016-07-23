package holding.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ReverseIteration {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 2, 3, 4, 5, 6);

        List<Integer> revInts = new ArrayList<>();
        reverseFill(ints, revInts);
        System.out.println(ints);
        System.out.println(revInts);
    }

    private static void reverseFill(List<Integer> ints, List<Integer> revInts) {
        int len = ints.size();
        ListIterator<Integer> it = ints.listIterator(len);

        while (it.hasPrevious()) {
            int val = it.previous();
            revInts.add(val);
        }
    }

}
