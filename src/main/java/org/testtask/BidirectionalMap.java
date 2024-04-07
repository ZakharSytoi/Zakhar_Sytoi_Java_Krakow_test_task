package org.testtask;

interface BidirectionalMap<K, V> {
    void put(K key, V value);

    V get(K key);

    K getKey(V value);

    boolean containsKey(K key);

    boolean containsValue(V value);

    int size();
}
