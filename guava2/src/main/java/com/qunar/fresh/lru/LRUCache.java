package com.qunar.fresh.lru;

import com.google.common.collect.ImmutableMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liyingsong on 16-5-24.
 */
public class LRUCache<K, V> implements Cache<K,V> {
    private LinkedHashMap<K, V> cache;
    private static final int MAX_CAPACITY = 1024;
    private static final float LOAD_FACTOR = 0.75f;
    private static boolean ACCESS_ORDER = true;
    private int size = 0;

    public LRUCache(final int size, float loadFactor, boolean accessOrder) {
        cache = new LinkedHashMap<K, V>(size, loadFactor, accessOrder) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > size;
            }
        };
        this.size = size;
    }

    @Override
    public V get(K key) {
        V value = cache.get(key);
        return value;
    }

    @Override
    public ImmutableMap<K, V> getAll() {
        return ImmutableMap.copyOf(cache);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public int getSize() {
        return cache.size();
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
