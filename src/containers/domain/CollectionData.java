package containers.domain;

import java.util.ArrayList;

import generics.abst.Generator;

public class CollectionData<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;

    public CollectionData(Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            add(gen.generate());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int n) {
        return new CollectionData<T>(gen, n);
    }
}
