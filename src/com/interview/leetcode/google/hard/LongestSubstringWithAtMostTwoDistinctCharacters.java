package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
  public int totalFruit(int[] tree) {
    Map<Integer, Integer> basket = new HashMap<>();
    int maxFruitInBasket = 0;
    for (int left = 0, right = 0; right < tree.length; right++) {
      int currentFruit = tree[right];
      basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);
      while (basket.size() > 2) {
        int leftFruit = tree[left];
        int quantity = basket.get(leftFruit);
        if (quantity == 1) basket.remove(leftFruit);
        else basket.put(leftFruit, quantity - 1);
        left++;
      }
      maxFruitInBasket = Math.max(maxFruitInBasket, right - left + 1);
    }
    return maxFruitInBasket;
  }
}
