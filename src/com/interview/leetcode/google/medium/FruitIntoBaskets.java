package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
* https://leetcode.com/problems/fruit-into-baskets/description/
*
* Problem Understanding: At any-time I can pick and fill basket from "2 continuous same type of tree".
* So the basket can hold only 2 variety of fruit.
* When encountering a new tree. "keep last encountered" fruit and start fill next fruit to make it continuous.

* Ex: [banana, banana, banana, apple, banana, apple, cherry, cherry]...
* fill basket1 with banana,banana,banana.
* fill basket2 with apple
* fill basket1 with banana
* fill basket2 with apple
* Throw away banana.. fill cherry cherry
*
* This problem is same as "LongestSubstringWithAtMostTwoDistinctCharacters_SlidingWindow.java" with K=2
* ===============================Solution=============================
* 1) Simple sliding window algorithm
* 2) If the basket has more than "required variety(Ex:k=2)" then remove fruit from basket till k==2.
* ===================================================================
*/
public class FruitIntoBaskets {

  public int totalFruit(int[] tree) {
    int maxFruitIntoBasket = 0;
    Map<Integer, Integer> basket = new HashMap<>();
    for (int left = 0, right = 0; right < tree.length; right++) {
      int currFruit = tree[right];
      basket.put(currFruit, basket.getOrDefault(currFruit, 0) + 1);
      while (basket.size() > 2) {
        int currFruitToRemove = tree[left];
        if (basket.get(currFruitToRemove) == 1) basket.remove(currFruitToRemove);
        else basket.put(currFruitToRemove, basket.get(currFruitToRemove) - 1);
        left++; // shrink the window
      }
      maxFruitIntoBasket = Math.max(maxFruitIntoBasket, right - left + 1);
    }
    return maxFruitIntoBasket;
  }

  // Don't delete the code. Took more than 3 hours to write
  public int totalFruit1(int[] tree) {
    Map<Integer, Integer> basket = new HashMap<>();
    int maxFruitIntoBasket = 0;
    for (int left = 0, right = 0; right < tree.length; right++) {
      int currFruit = tree[right];
      if (basket.containsKey(currFruit)) {
        basket.put(currFruit, right);
      } else {
        if (basket.size() == 2) {
          int prevFruit = tree[right - 1];
          Iterator<Integer> setIterator = basket.keySet().iterator();
          int fruit1 = setIterator.next();
          int fruit2 = setIterator.next();
          if (fruit1 == prevFruit) {
            left = basket.get(fruit2) + 1;
            basket.remove(fruit2);
          } else {
            left = basket.get(fruit1) + 1;
            basket.remove(fruit1);
          }
        }
        basket.put(currFruit, right);
      }
      maxFruitIntoBasket = Math.max(maxFruitIntoBasket, right - left + 1);
    }
    return maxFruitIntoBasket;
  }

}
