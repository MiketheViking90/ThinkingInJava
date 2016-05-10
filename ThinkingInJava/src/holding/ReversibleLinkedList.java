package holding;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ReversibleLinkedList<T> extends LinkedList<T> {

    private static final long serialVersionUID = 1L;

    public ReversibleLinkedList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reverseIterable() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {

                    int curIndex = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return curIndex > -1;
                    }

                    @Override
                    public T next() {
                        return get(curIndex--);
                    }

                };
            }

        };
    }
}
