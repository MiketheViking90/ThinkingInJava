package holding;

import java.util.Collection;
import java.util.HashSet;

public class SimpleCollection {

    public static void main(String[] args) {
        Collection<Integer> col = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            col.add(i);
        }

        for (int i = 5; i < 15; i++) {
            col.add(i);
        }

        for (Integer i : col) {
            System.out.print(i + ", ");
        }
    }
}
