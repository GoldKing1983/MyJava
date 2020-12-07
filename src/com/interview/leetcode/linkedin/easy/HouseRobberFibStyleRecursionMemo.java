package com.interview.leetcode.linkedin.easy;

/*
Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.

As compared to HouseRobberRecursion, this is bottomUp.

 */

public class HouseRobberFibStyleRecursionMemo {
  public int rob(int[] nums) {
    return rob(nums, nums.length - 1, new Integer[nums.length]);
  }

  private int rob(int[] nums, int i, Integer[] dp) {
    if (i < 0) return 0;
    if (dp[i] != null) return dp[i];

    int left = rob(nums, i - 2, dp) + nums[i];
    int right = rob(nums, i - 1, dp);
    dp[i] = Math.max(left, right);
    return dp[i];
  }
}
