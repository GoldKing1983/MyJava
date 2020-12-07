package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
https://leetcode.com/problems/insert-delete-getrandom-o1/description/

1) Understand InsertDeleteGetRandom
2) Same logic as InsertDeleteGetRandom. Instead of list here another map is used.


Before Remove     ---- keyMap = {10=1, 20=2, 30=3, 40=4}, valueMap = {1=10, 2=20, 3=30, 4=40}
After Remove of 20---- keyMap = {10=1,       30=3, 40=2}, valueMap = {1=10, 2=40, 3=30}

2Step for keyMap
	Step1: Remove 20
	Step2: Update 40 with 2

2Step for valueMap
	Step1: Remove 4
	Step2: Update 2 with 40
 */
public class InsertDeleteGetRandomUsing2HashMap {
  private Map<Integer, Integer> keyMap;
  private Map<Integer, Integer> valueMap;
  int count;

  public InsertDeleteGetRandomUsing2HashMap() {
    keyMap = new HashMap<>();
    valueMap = new HashMap<>();
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
    valueMap.put(count, val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int valueToRemove) {
    if (keyMap.containsKey(valueToRemove)) {
      int keyMapValue = keyMap.get(valueToRemove);
      keyMap.remove(valueToRemove); // Remove 20
      // If the size is 1 or valueToRemove is at top, then just remove. No swap needed.
      if (count == 1 || keyMapValue == count) {
        valueMap.remove(keyMapValue);
      } else {
        int valueMapValue = valueMap.get(count);
        keyMap.put(valueMapValue, keyMapValue); // Update 40 with 2
        valueMap.remove(count); // Remove 4
        valueMap.put(keyMapValue, valueMapValue); // Update 2 with 40
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
    return valueMap.get(n);
  }
}
