package containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import containers.domain.Countries;

public class Lists {

    private static boolean b;
    private static String s;
    private static int i;
    private static  Iterator<String> it;
    private static ListIterator<String> lit;

    public static void main(String[] args) {
        basicTest(
                new LinkedList<String>(Countries.names(25)));
        basicTest(
                new ArrayList<String>(Countries.names(25)));

        iterMotion(
                new LinkedList<String>(Countries.names(25)));
        iterMotion(
                new ArrayList<String>(Countries.names(25)));

        iterManipulation(
                new LinkedList<String>(Countries.names(25)));
        iterManipulation(
                new ArrayList<String>(Countries.names(25)));

        testVisual(
                new LinkedList<String>(Countries.names(25)));
        testVisual(
                new ArrayList<String>(Countries.names(25)));

        testLinkedList();

    }

    public static void basicTest(List<String> l) {
        System.out.println("--- Basic Test ---");
        // Insertion/deletion in mid list is cheap for LinkedList, expensive for ArrayList
        l.add(1, "x");
        l.add("x");
        System.out.println(l);

        l.addAll(Countries.names(25));
        l.addAll(3, Countries.names(25));
        System.out.println();

        b = l.contains("1");
        System.out.println(b);
        b = l.containsAll(Countries.names(25));
        System.out.println(b);

        // Random access is cheap for ArrayList, expensive for LinkedList
        s = l.get(1);
        System.out.println(s);
        i = l.indexOf("1");
        System.out.println(i);
        b = l.isEmpty();
        System.out.println(b);

        it = l.iterator();
        lit = l.listIterator();
        lit = l.listIterator(3);

        i = l.lastIndexOf("1");
        l.remove(1);
        l.remove("3");
        l.set(1, "y");

        l.retainAll(Countries.names(25));
        System.out.println(l);
        l.removeAll(Countries.names(25));
        System.out.println(l);
        i = l.size();
        System.out.println(i);
        l.clear();
        System.out.println(l);
    }

    public static void iterMotion(List<String> l) {
        System.out.println("--- Iterator Motion ---");
        lit = l.listIterator();
        b = lit.hasNext();
        b = lit.hasPrevious();

        s = lit.next();
        i = lit.nextIndex();
        System.out.println(s + ", " + i);

        s = lit.previous();
        i = lit.previousIndex();
        System.out.println(s + ", " + i);
    }

    public static void iterManipulation(List<String> l) {
        System.out.println("--- Iterator Manipulation ---");
        lit = l.listIterator();
        lit.add("47");
        System.out.println(l);
        lit.next();
        lit.remove();
        System.out.println(l);
        lit.next();
        lit.set("42");
        System.out.println(l);
    }

    public static void testVisual(List<String> l) {
        System.out.println("--- Visual Test ---");
        System.out.println(l);
        List<String> l1 = Countries.names(25);
        System.out.println("l1: " + l1);
        l.addAll(l1);
        l.addAll(l1);
        System.out.println(l);

        lit = l.listIterator(l.size() / 2);
        lit.add("one");
        System.out.println(l);
        System.out.println(lit.next());
        lit.remove();
        System.out.println(lit.next());
        lit.set("42");
        System.out.println(l);
        lit = l.listIterator(l.size());
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
    }

    private static void testLinkedList() {
        System.out.println("--- LinkedList Test ---");
        LinkedList<String> ll = new LinkedList<>();
        ll.addAll(Countries.names(25));
        System.out.println(ll);

        ll.addFirst("one");
        ll.addFirst("two");
        System.out.println(ll);

        System.out.println(ll.getFirst());

        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
    }
}
