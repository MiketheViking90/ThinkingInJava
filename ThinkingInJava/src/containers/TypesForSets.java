package containers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import containers.domain.HashType;
import containers.domain.SetType;
import containers.domain.TreeType;

public class TypesForSets {

    public static void main(String[] args) {
        test(new HashSet<HashType>(), HashType.class);
        test(new LinkedHashSet<HashType>(), HashType.class);
        test(new TreeSet<TreeType>(), TreeType.class);

        System.out.println("--- Invalid Sets ---");
        test(new HashSet<SetType>(), SetType.class);
        test(new HashSet<TreeType>(), TreeType.class);
        test(new LinkedHashSet<SetType>(), SetType.class);
        test(new LinkedHashSet<TreeType>(), TreeType.class);

        HashSet<HashType> hs = new HashSet<>();
        HashType ht1 = new HashType(1);
        HashType ht2 = new HashType(1);
        hs.addAll(Arrays.asList(ht1, ht2));
        System.out.println(hs);

        HashSet<SetType> hs1 = new HashSet<>();
        SetType st1 = new SetType(1);
        SetType st2 = new SetType(1);
        hs1.addAll(Arrays.asList(st1, st2));
        System.out.println(hs1);
    }

    public static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for (int i = 0; i < 10; i++) {
                set.add(
                        type.getConstructor(int.class).newInstance(i));
            }
            return set;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }
}
