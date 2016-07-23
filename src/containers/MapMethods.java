package containers;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import containers.domain.CountingMapData;

public class MapMethods {

    private static void printKeys(Map<Integer, String> map) {
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: " + map.keySet());
        System.out.println();
    }

    private static void test(Map<Integer, String> map) {
        System.out.print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        System.out.println(map);
        System.out.println("Values: " + map.values());
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));

        int key = map.keySet().iterator().next();
        System.out.println("First key: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty() " + map.isEmpty());

        map.putAll(new CountingMapData(25));
        map.keySet().clear();
        System.out.println(map);
    }
    public static void main(String[] args) {
        test(new HashMap<Integer, String>());
        test(new TreeMap<Integer, String>());
        test(new LinkedHashMap<Integer, String>());
        test(new IdentityHashMap<Integer, String>());
    }
}
