package com.interview.leetcode.topic.design;

import java.util.LinkedHashMap;

/*
https://leetcode.com/problems/lru-cache/
===============================================Requirement=======================================================================
Design LRU Cache such that get and put should be in O(1). See picture "LRU-HowItWorks.png"
===============================================High Level Idea===================================================================
1) LinkedHashMap by default works like queue.
Ex: "a b c d e" - insert "a", insert "b", insert "c", insert "d", insert "e",
    When we iterate, it start from "a" which is firstInserted or oldest
    So to remove operation by iterator removes the "oldest", which is key to solution remove at O(1)
2) When a get happens, if element present, remove previous entry and add it again.
3) When a PUT happens 3 cases are possible
	a) if key present, remove previousEntry and add it again.
 	b) if capacity not reached, just add it. Key will be at top or recent
 	c) if capacity is reached, get "oldestKey" key using iterator. remove "oldestKey" and Put new key/value.

==================================================Problem with this approach=====================================================

 */
public class LRUCacheUsingLinkedHashMap {
  private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
  private int capacity;

  public LRUCacheUsingLinkedHashMap(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    int val = map.remove(key);
    put(key, val);
    return val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) { // key present, remove previousEntry and add it again.
      map.remove(key);
      map.put(key, value);
    } else if (map.size() < capacity) { // capacity not reached, just add it. Key will be at top or recent
      map.put(key, value);
    } else { // capacity is reached, get "oldestKey" key using iterator. remove "oldestKey" and Put new key/value.
      int oldestKey = map.entrySet().iterator().next().getKey();
      map.remove(oldestKey);
      map.put(key, value);
    }
  }
}
