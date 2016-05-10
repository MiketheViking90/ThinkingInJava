package containers.exercises;

import java.util.Iterator;

public class SingleListIterator<T> implements Iterator<T> {

    private Link<T> cur;

    public SingleListIterator(Link<T> link) {
        cur = link;
    }

    @Override
    public boolean hasNext() {
        return cur.next != null;
    }

    @Override
    public T next() {
        T data = cur.data;
        cur = cur.next;
        return data;
    }

    public void add(T t) {
        Link<T> prevNext = cur.next;
        cur.next = new Link<T>(t);
        cur.next.next = prevNext;
    }

    @Override
    public void remove() {
        cur.next = cur.next.next;
    }
}
