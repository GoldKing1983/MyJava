package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

======================================================================Data Flow Analysis======================================================================
input = [1,2,3,-5]

dp[] = [1, 0, 0, 0]  ---> Sum from 0 to 0

dp[] = [1, 3, 0, 0]  ---> Sum from 0 to 1

dp[] = [1, 3, 6, 0]  ---> Sum from 0 to 2

dp[] = [1, 3, 6, 1]  ---> Sum from 0 to 3

query = 0 to 2 -> dp[2] = 6 = 5  ==> return directly 6...
query = 1 to 2 -> dp[2] - dp[0] = 6-1 = 5
query = 1 to 3 -> dp[3] - dp[0] = 1-1 = 0
 */
public class RangeSumQueryImmutable {
  private int[] dp;

  public RangeSumQueryImmutable(int[] nums) {
    dp = new int[nums.length];
    for (int i = 1; i < nums.length; i++) nums[i] = nums[i - 1] + nums[i];
    dp = nums;
  }

  public int sumRange(int i, int j) {
    if (i == 0) return dp[j];
    return dp[j] - dp[i - 1];
  }
}
