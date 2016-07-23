package containers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        Iterator<K> keyIt = keys.iterator();
        Iterator<V> valIt = values.iterator();

        Set<Map.Entry<K, V>> entrySet = new HashSet<Map.Entry<K, V>>();
        while (keyIt.hasNext()) {
            K key = keyIt.next();
            V val = valIt.next();
            entrySet.add(new SimpleEntry<K, V>(key, val));
        }
        return entrySet;
    }

    @Override
    public V get(Object key) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            return values.get(index);
        } else {
            return null;
        }
    }

    @Override
    public V put(Object key, Object val) {
        return null;
    }

}
