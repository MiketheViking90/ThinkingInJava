package containers;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;

public class AssociativeArray<K, V> {

    @Getter private Object[][] pairs;
    private int index;

    public AssociativeArray(int l) {
        pairs = new Object[l][2];
    }

    public void put(K key, V val) {
        if (index > pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        pairs[index++] = new Object[]{key, val};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            Object[] pair = pairs[i];
            if (pair[0].equals(key)) {
                return (V) pair[1];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AssociativeArray<String, Integer> map = new AssociativeArray<>(5);
        Map<String, Integer> map1 = new LinkedHashMap<>();

        map1.put("three", 3);
        map1.put("one", 1);
        map1.put("five", 5);
        map1.put("two", 2);
        map1.put("four", 4);

        System.out.println(map.get(("two")));
        Object[][] data = map.getPairs();
        for (Object[] pair : data) {
            System.out.print(pair[0]);
            System.out.print(pair[1]);
            System.out.println();
        }
        System.out.println(map1);
    }
}
