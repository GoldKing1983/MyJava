package com.sample.tricky;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lru-cache/
 *
 * Note:(This feature is called Ordered dictionary)
 * 1) Flag accessOrder rearranges the data ones get() is called.
 * So all the time recently visited or inserted will be at head or top.
 *
 * 2) If size goes more than specified then Bottom or tail is removed.
 */
public class LRUCache1 {

  class MyLRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public MyLRUCache(int capacity) {
      super(capacity, 0.75F, true);
      this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > capacity;
    }

  }

  private MyLRUCache lruCache;

  public LRUCache1(int capacity) {
    // Initialize linked hash map with accessOrder true
    lruCache = new MyLRUCache(capacity);
  }

  public void put(int key, int value) {
    lruCache.put(key, value);
  }

  public int get(int key) {
    return lruCache.getOrDefault(key, -1);
  }

}
