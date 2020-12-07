package com.sample.datastructure.tree.dfs;

/*
https://leetcode.com/problems/target-sum/description/

Requirement:
1) Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
2) All numbers should be included in result.

Input: {1, 1, 2, 3}, S=1
Output: 3
Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}

Input: {1, 2, 7, 1}, S=9
Output: 2
Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}

============================================================Solution Approach==========================================================
1) Similar to GroupSum Problem.
2) Recurse for + and -.
 */
public class TargetSum {

  int count = 0;

  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    dfs(nums, 0, sum, S);
    return count;
  }

  public void dfs(int[] nums, int start, int currentSum, int target) {
    if (start == nums.length) {
      if (currentSum == target) count++;
      return;
    }
    dfs(nums, start + 1, currentSum + nums[start], target);
    dfs(nums, start + 1, currentSum - nums[start], target);
  }
}
