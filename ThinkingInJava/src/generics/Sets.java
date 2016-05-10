package generics;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> res = set1;
        res.addAll(set2);
        return res;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }


}
