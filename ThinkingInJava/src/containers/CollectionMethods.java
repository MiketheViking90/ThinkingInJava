package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import containers.domain.Countries;

public class CollectionMethods {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        makeArrayFromList(c);
        makeStringArrayFromList(c);
        findMaxAndMin(c);

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);
        c.remove(Countries.DATA[0][0]);
        System.out.println(c);
        c.remove(Countries.DATA[1][0]);
        System.out.println(c);
        c.removeAll(c2);
        System.out.println(c);

        isElementInCollection(c);
        isCollectionInCollection(c2, c);

        Collection<String> c3 = ((List<String>)c).subList(0, 2);
        c2.retainAll(c3);
        System.out.println(c2);

        clearCollection();
    }

    private static void clearCollection() {
        Collection<String> c = new ArrayList<>(Countries.names(6));
        System.out.println(c);
        c.clear();
        System.out.println(c);
    }

    private static void isCollectionInCollection(Collection<String> c2, Collection<String> c) {
        System.out.println(c.containsAll(c2));
    }

    private static void isElementInCollection(Collection<String> c) {
        String val = Countries.DATA[3][0];
        System.out.println(c.contains(val));
    }

    private static void findMaxAndMin(Collection<String> c) {
        System.out.println("Max: " + Collections.max(c));
        System.out.println("Min: " + Collections.min(c));
    }

    private static void makeArrayFromList(Collection<String> c) {
        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));
    }

    private static void makeStringArrayFromList(Collection<String> c) {
        String[] array = c.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }

}
