package com.interview.leetcode.amazon.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/set-mismatch/description/
 *
 *
 * Input : 1 1 -> missing number is 2
 * Input : 2 2 -> missing number is 1.
 *
 */
public class SetMismatch {

  public int[] findErrorNumsByFormula(int[] nums) {
    Set<Integer> set = new HashSet<>();
    Integer duplicate = 0;
    Integer totalSum = (nums.length * (nums.length + 1)) / 2;
    Integer currentSumWithOutDup = 0;
    for (Integer i : nums) {
      if (!set.add(i)) {
        duplicate = i;
      } else {
        currentSumWithOutDup += i;
      }
    }
    Integer missingNumber = totalSum - currentSumWithOutDup;
    return new int[] {duplicate, missingNumber};
  }

  /*
   * Input : 1, 1  --> map=[false, true, false]
   * Input : 2, 2  --> map=[false, false, true]
   */
  public int[] findErrorNumsBest(int[] nums) {
    if (nums.length < 2) return new int[0];
    int duplicate = -1;
    boolean[] map = new boolean[nums.length + 1];
    for (int n : nums) {
      if (map[n]) duplicate = n;
      else map[n] = true;
    }
    for (int i = 1; i < map.length; i++) {
      if (!map[i]) return new int[] {duplicate, i};
    }
    return null;
  }
}
