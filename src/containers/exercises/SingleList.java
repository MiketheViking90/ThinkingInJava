package containers.exercises;

import java.util.Iterator;

public class SingleList<T> implements Iterable<T> {

    private Link<T> current;

    public SingleList(T t) {
        current = new Link<>(t);
        current.next = null;
    }

    public void add(T t) {
        Link<T> ptr = current;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Link<>(t);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link<T> ptr = current;
        while (ptr != null) {
            sb.append(ptr.data + ">");
            ptr = ptr.next;
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleListIterator<T>(current);
    }

    public SingleListIterator<T> slIterator() {
        return new SingleListIterator<T>(current);
    }

    public static void main(String[] args) {
        SingleList<String> sl = new SingleList<>("a");
        sl.add("b");
        sl.add("c");
        sl.add("d");
        sl.add("e");
        sl.add("f");

        Iterator<String> it = sl.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for (String s : sl) {
            System.out.print(s + " ");
        }
        System.out.println();

        SingleListIterator<String> slit = sl.slIterator();
        slit.add("z");
        System.out.println(sl);
        slit.next();
        slit.next();
        slit.add("Vegeta");
        System.out.println(sl);
        slit.remove();
        slit.next();
        slit.next();
        slit.remove();
        System.out.println(sl);
    }
}
