package com.interview.leetcode.topic.recursion;

/*
Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.
 */

public class HouseRobberRecursionMemo {
    public int rob(int[] nums) {

      return recur(nums, nums.length, 0, new Integer[nums.length]);
    }

    private int recur(int[] nums, int n, int index, Integer[] dp) {
        if (index >= n) return 0;

        if (dp[index] != null) return dp[index];

        int include = recur(nums, n, index + 2, dp) + nums[index];
        int exclude = recur(nums, n, index + 1, dp);

        dp[index] = Math.max(include, exclude);
        return dp[index];
    }
}
