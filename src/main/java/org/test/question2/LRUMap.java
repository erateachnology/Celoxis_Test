package org.test.question2;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUMap<K, V> {
    private int capacity;
    private HashMap<K, V> map;
    private LinkedList<K> list;

    public LRUMap(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new LinkedList<>();
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
            return map.get(key);
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            list.remove(key);
            list.addFirst(key);
            map.put(key, value);
        } else {
            if (map.size() == capacity) {
                K oldestKey = list.removeLast();
                map.remove(oldestKey);
            }
            map.put(key, value);
            list.addFirst(key);
        }
    }
}
