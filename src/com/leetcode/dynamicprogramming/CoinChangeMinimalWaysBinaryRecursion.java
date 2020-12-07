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
public class CoinChangeMinimalWaysBinaryRecursion {

  public int coinChange(int[] nums, int target) {
    int result = coinChange(nums, target, 0, 0);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public int coinChange(int[] coins, int target, int index, int sum) {
    if (target == 0) return sum;
    if (target < 0) return Integer.MAX_VALUE;
    if (index == coins.length) return Integer.MAX_VALUE;
    int left = coinChange(coins, target - coins[index], index, sum + 1);
    int right = coinChange(coins, target, index + 1, sum);
    return Math.min(left, right);
  }
}
