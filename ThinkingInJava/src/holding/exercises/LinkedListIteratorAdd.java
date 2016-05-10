package holding.exercises;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIteratorAdd {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ListIterator<Integer> it = ll.listIterator();
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            it.add(i);
            cnt++;
            if (cnt % 2 == 0) {
                it.previous();
            }
            System.out.println(ll);
        }
    }

}
