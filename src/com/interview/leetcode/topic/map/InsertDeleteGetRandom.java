package com.interview.leetcode.topic.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
https://leetcode.com/problems/insert-delete-getrandom-o1/description/
========================Question=============================
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the "same probability" of being returned.

=============Note:==================
1) The key point hashMap supports insert and delete at O(1).
2) But to get random element, I need to have data structure that supports index.
Option1: I can use arrayList. But when a element is deleted from hashMap, it needs to be deleted from arrayList too.
But if a  element in arrayList is anywhere other than end. Then shuffling needs to be done.
To avoid that, we move the element from last index to element to be deleted index and delete last index.
Then map also has to updated with the new index.
Option2: use 2 hashMap keyMap and valueMap.. But Option1 is best.
===========Removal Operation================
1) take an example after insert 10, 20 ,30 in order
2) valueMap:[10,0][20,1][30,2] value:[10,20,30]
3) lets say we want to remove(10),
4) valueMap of 10 will give 0.
5) So take lastElement from list and move it 0th index.
6) Remove last element from list.
7) Update valueMap 30 with 0. Remove 10 from valueMap.
  =====================
 */
public class InsertDeleteGetRandom {
  // Key is actual data, value is index of list
  private Map<Integer, Integer> valueMap;
  private List<Integer> value;
  private Random rand = new Random();

  public InsertDeleteGetRandom() {
    valueMap = new HashMap<>();
    value = new ArrayList<>();
  }

  public boolean insert(int val) {
    if (valueMap.containsKey(val)) return false;
    int n = value.size();
    valueMap.put(val, n);
    return value.add(val);
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (valueMap.containsKey(val)) {
      int n = value.size() - 1; // list start from 0. So -1;
      int index = valueMap.get(val);
      // If the size is 1 or valueToRemove is at top, then just remove. No swap needed.
      if (index == n) {
        valueMap.remove(val);
        value.remove(n);
      } else {
        int lastIndexValue = value.get(n);
        value.set(index, lastIndexValue);
        valueMap.put(lastIndexValue, index);
        valueMap.remove(val);
        value.remove(n);
      }
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int n = value.size();
    // for 10size. generate random from 0 to 9, which is best suited for list, as list start from 0.
    return value.get(rand.nextInt(n));
  }
}
