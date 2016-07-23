package containers.exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import containers.domain.Countries;

public class ListIteratorInsertion {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Countries.names(5));
        LinkedList<String> ll = new LinkedList<>(Countries.names(10));

        for (int i = 0; i < 5; i++) {
            ll.removeFirst();
        }

        iteratorPrint(al);
        iteratorPrint(ll);

        listIteratorInsert(new ArrayList<>(al), new LinkedList<>(ll));
        listIteratorInsert(new LinkedList<>(ll), new ArrayList<>(al));

        listIteratorReverseInsert(new ArrayList<>(al), new LinkedList<>(ll));
        listIteratorReverseInsert(new LinkedList<>(ll), new ArrayList<>(al));
    }

    private static void iteratorPrint(List<String> l) {
        System.out.println("--- Iterator Print ---");
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
    }

    private static void listIteratorInsert(List<String> insertee, List<String> inserted) {
        System.out.println("--- Iterator Insert ---");
        ListIterator<String> lit1 = insertee.listIterator();
        ListIterator<String> lit2 = inserted.listIterator();
        System.out.println(insertee);
        System.out.println(inserted);
        while (lit2.hasNext()) {
            lit1.add(lit2.next());
            lit1.next();
        }
        System.out.println(insertee);
        System.out.println();
    }

    private static <T> void listIteratorReverseInsert(List<T> insertee, List<T> inserted) {
        System.out.println("--- Iterator Backwards Insert ---");
        System.out.println(insertee);
        System.out.println(inserted);

        ListIterator<T> lit1 = insertee.listIterator(insertee.size());
        ListIterator<T> lit2 = inserted.listIterator(inserted.size());

        while (lit2.hasPrevious()) {
            lit1.add(lit2.previous());
            lit1.previous();
        }
        System.out.println(insertee);
        System.out.println();
    }
}
