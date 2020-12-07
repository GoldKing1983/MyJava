package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change/description/
https://www.youtube.com/watch?v=Y0ZqKpToTic
=============================================================Requirement=========================================================
You are given coins of different denominations and a total amount of money amount. Write a function to compute the 
fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
combination of the coins,  return -1.
===============================================================Example1==========================================================
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
===============================================================Example2==========================================================
Input: coins = [2], amount = 3
Output: -1
 
 */
public class CoinChangeMinimalWaysForLoopRecursion {

  public int coinChange(int[] nums, int target) {
    recur(nums, nums.length, 0, target, 0, 0);
    return minCount == Integer.MAX_VALUE ? -1 : minCount;
  }

  int minCount = Integer.MAX_VALUE;

  private void recur(int[] nums, int n, int index, int target, int sum, int count) {
    if (target == sum) {
      minCount = Math.min(minCount, count);
      return;
    }
    if (sum > target) return;

    if (index == n) return;

    for (int i = index; i < n; i++) {
      sum += nums[i];
      count++;
      recur(nums, n, i, target, sum, count);
      count--;
      sum -= nums[i];
    }
  }
}
