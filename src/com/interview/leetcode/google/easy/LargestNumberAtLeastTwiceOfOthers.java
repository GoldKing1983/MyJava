package com.interview.leetcode.google.easy;

public class LargestNumberAtLeastTwiceOfOthers {
  public int dominantIndex(int[] nums) {
    int max1 = 0, max2 = 0;
    int max1Index = 0;
    int i = 0;
    for (int num : nums) {
      if (num > max1) {
        max2 = max1;
        max1 = num;
        max1Index = i;
      } else if (num > max2) {
        max2 = num;
      }
      i++;
    }
    // For the case [0,0,1] and [0,0,0]
    if (max2 == 0) return max1 > 0 ? max1Index : -1;

    return max2 * 2 <= max1 ? max1Index : -1;
  }
}
