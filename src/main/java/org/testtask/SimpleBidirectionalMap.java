package org.testtask;

import java.util.HashMap;
import java.util.Map;

class SimpleBidirectionalMap<K, V> implements BidirectionalMap<K, V>{
    private final Map<K, V> forwardMap = new HashMap<>();
    private final Map<V, K> reverseMap = new HashMap<>();

    public void put(K key, V value) {
        forwardMap.put(key, value);
        reverseMap.put(value, key);
    }

    public V get(K key) {
        return forwardMap.get(key);
    }

    public K getKey(V value) {
        return reverseMap.get(value);
    }

    public boolean containsKey(K key) {
        return forwardMap.containsKey(key);
    }

    public boolean containsValue(V value) {
        return reverseMap.containsKey(value);
    }

    public int size() {
        return forwardMap.size();
    }

}