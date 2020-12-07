package com.interview.leetcode.linkedin.easy;

/*
Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.

As compared to HouseRobberRecursion, this is bottomUp. 

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
