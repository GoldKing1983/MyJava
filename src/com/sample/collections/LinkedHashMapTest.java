package com.sample.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapTest {

  public static void main(String[] args) {
    Map<Integer, Integer> cache = new HashMap<>(10);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    cache.put(6, 6);
    cache.put(7, 7);
    cache.put(8, 8);
    cache.put(9, 9);
    cache.put(10, 10);

    System.out.println(cache.entrySet().iterator().next().getKey()); // Prints 1. First Inserted

    cache.get(5);
    System.out.println(cache);

    Iterator<Entry<Integer, Integer>> entry = cache.entrySet().iterator();
    System.out.println(entry.next().getKey());
    while (entry.hasNext()) {
      System.out.println(entry.next().getKey());
    }
  }
}
