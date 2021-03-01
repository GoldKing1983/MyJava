package com.interview.leetcode.topic.recursion;

/*
Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.

As compared to HouseRobberRecursion, this is bottomUp. 
f(n) = Math.max(f(n-2)+f(n),f(n-1))
 */

public class HouseRobberFibStyleRecursion {
  public int rob(int[] nums) {
    return rob(nums, nums.length - 1);
  }

  private int rob(int[] nums, int i) {
    if (i < 0) return 0;

    int left = rob(nums, i - 2) + nums[i];
    int right = rob(nums, i - 1);
    return Math.max(left, right);
  }
}
