package containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import containers.domain.Countries;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private static final int HASH_SIZE = 997;
    @SuppressWarnings("unchecked")
    private List<SimpleEntry<K, V>>[] buckets = new LinkedList[HASH_SIZE];

    @Override
    public V put(K key, V val) {
        int index = hashFunction(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<SimpleEntry<K, V>>();
        }
        LinkedList<SimpleEntry<K, V>> bucket = (LinkedList<java.util.AbstractMap.SimpleEntry<K, V>>) buckets[index];
        SimpleEntry<K, V> pair = new SimpleEntry<>(key, val);

        for (SimpleEntry<K, V> entry : bucket) {
            if (entry.equals(pair)) {
                return updateVal(entry, val);
            }
        }

        bucket.add(pair);
        return null;
    }

    private int hashFunction(Object key) {
        return Math.abs(key.hashCode() % HASH_SIZE);
    }

    @Override
    public V get(Object key) {
        int index = hashFunction(key);

        List<SimpleEntry<K, V>> bucket = buckets[index];
        if (bucket == null) {
            return null;
        }

        return findVal(bucket, key);
    }

    private V findVal(List<java.util.AbstractMap.SimpleEntry<K, V>> bucket, Object key) {
        for (SimpleEntry<K, V> entry : bucket) {
            boolean equalKeys = entry.getKey().equals(key);
            if (equalKeys) {
                return entry.getValue();
            }
        }
        return null;
    }

    private V updateVal(SimpleEntry<K, V> entry, V val) {
        V prevVal = entry.getValue();
        entry.setValue(val);
        return prevVal;
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entries = new HashSet<>();
        for (List<SimpleEntry<K, V>> buckets : buckets) {
            entries.addAll(buckets);
        }
        return entries;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> simpleMap = new SimpleHashMap<>();
        simpleMap.put("1", "one");
        simpleMap.put("2", "one");
        simpleMap.put("3", "one");
        simpleMap.put("4", "one");
        System.out.println(simpleMap.get("1"));

        simpleMap.putAll(Countries.capitals(25));
        System.out.println(simpleMap.get("ERITREA"));
        Set<java.util.Map.Entry<String, String>> set = simpleMap.entrySet();

    }

}
