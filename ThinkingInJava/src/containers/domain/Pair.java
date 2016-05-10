package containers.domain;

import lombok.Getter;

public class Pair<K, V> {

    @Getter private final K key;
    @Getter private final V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}
