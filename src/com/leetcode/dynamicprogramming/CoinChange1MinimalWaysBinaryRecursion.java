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
public class CoinChange1MinimalWaysBinaryRecursion {
    public int coinChange(int[] nums, int target) {
        int result = coinChange(nums, target, 0, 0, nums.length);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int coinChange(int[] coins, int target, int index, int coinCount, int n) {
        if (target == 0) return coinCount;
        if (target < 0) return Integer.MAX_VALUE;
        if (index == n) return Integer.MAX_VALUE;
        int left = coinChange(coins, target - coins[index], index, coinCount + 1, n);
        int right = coinChange(coins, target, index + 1, coinCount, n);
        return Math.min(left, right);
    }
}
