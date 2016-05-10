package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> col = new ArrayList<>();
        Integer[] moreInts = {6, 7, 8, 9, 10};
        Collection<Integer> evenMoreInts = Arrays.asList(1, 2, 3, 4, 5);

        col.addAll(evenMoreInts);
        col.addAll(Arrays.asList(moreInts));
        Collections.addAll(col, 1, 2, 3, 4, 5);
        Collections.addAll(col, moreInts);

        System.out.println(col);
    }
}
