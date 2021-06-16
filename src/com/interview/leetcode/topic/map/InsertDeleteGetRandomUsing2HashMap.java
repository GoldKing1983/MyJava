package com.interview.leetcode.topic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
https://leetcode.com/problems/insert-delete-getrandom-o1/description/

1) Understand InsertDeleteGetRandom
2) Same logic as InsertDeleteGetRandom. Instead of list here another map is used.


Before Remove     ---- keyMap = {10=1, 20=2, 30=3, 40=4}, indexMap = {1=10, 2=20, 3=30, 4=40}
After Remove of 20---- keyMap = {10=1,       30=3, 40=2}, indexMap = {1=10, 2=40, 3=30}

delete operation:
Ex: delete 20.

3Step for keyMap
	Step1: Remove 20 . Cache the value. i.e 2
	Step2: get the size of indexMap. i.e 4. get value of 4 from indexMap. i.e 40
	Step3: Update keyMap 40 with 2

2Step for indexMap
	StepA: Remove 4 where 4 is the size of indexMap.
	StepB: Update 2 with 40. 2 is already cached in step1. 4 is already cached in step2
 */
public class InsertDeleteGetRandomUsing2HashMap {
  private Map<Integer, Integer> keyMap;
  private Map<Integer, Integer> indexMap;
  int count;

  public InsertDeleteGetRandomUsing2HashMap() {
    keyMap = new HashMap<>();
    indexMap = new HashMap<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (keyMap.containsKey(val)) {
      return false;
    }
    count++;
    keyMap.put(val, count);
    indexMap.put(count, val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int valueToRemove) {
    if (keyMap.containsKey(valueToRemove)) {
      int indexToRemove = keyMap.remove(valueToRemove); // Remove 20
      // If the size is 1 or indexToRemove is at top, then just remove. No swap needed.
      if (count == 1 || indexToRemove == count) {
        indexMap.remove(indexToRemove);
      } else {
        int indexMapValue = indexMap.get(count);
        keyMap.put(indexMapValue, indexToRemove); // Update 40 with 2
        indexMap.remove(count); // Remove 4
        indexMap.put(indexToRemove, indexMapValue); // Update 2 with 40
      }
      count--;
      return true;
    }
    return false;
  }

  Random random = new Random();

  /** Get a random element from the set. */
  public int getRandom() {
    // Ex: for 10 size. random generates between 0 to 9. Since we use from 1 to 10. Adding 1.
    int n = random.nextInt(count) + 1;
    return indexMap.get(n);
  }
}
