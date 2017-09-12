package com.qunar.fresh.lru;

import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

/**
 * Created by liyingsong on 16-5-23.
 */
public interface Cache<K, V> {
    V get(K key);
    ImmutableMap<K, V> getAll();
    void put(K key, V value);
    int getSize();
    void remove(K key);
    void clear();
}
