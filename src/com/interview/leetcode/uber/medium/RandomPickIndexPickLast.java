package com.interview.leetcode.uber.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
Same code as RandomPickIndex. Keeping Winner Index as last rather than 0
*/
public class RandomPickIndexPickLast {
  private Map<Integer, List<Integer>> map = new HashMap<>();
  private Random random = new Random();

  public RandomPickIndexPickLast(int[] nums) {
    for (int i = 0; i < nums.length; ++i)
      map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
  }

  public int pick(int target) {
    int res = 0, count = 1;
    for (int index : map.get(target)) {
      int currentRandom = random.nextInt(count);
      if (currentRandom + 1 == count) res = index;
      count++;
    }
    return res;
  }
}
