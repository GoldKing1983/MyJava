package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:

[]
[1]
[1, 1]
[1, 1, 1]
[1, 1, 1, 1]
[1, 1, 1, 1, 1]
[1, 1, 1, 1]
[1, 1, 1, 1, 2]
[1, 1, 1, 1]
[1, 1, 1, 1, 5]
[1, 1, 1, 1]
[1, 1, 1]
[1, 1, 1, 2]
[1, 1, 1]
[1, 1, 1, 5]
[1, 1, 1]
[1, 1]
[1, 1, 2]
[1, 1]
[1, 1, 5]
[1, 1]
[1]
[1, 2]
[1]
[1, 5]
[1]
[]
[2]
[]
[5]
[]


====================================================Where Memo is needed====================================================
Ex:
Input: amount = 5, coins = [1, 2, 5]

 "coin2" with remaining "sum 3" might be calculated in "coin1".
 We can reuse, when "coin2" recursion goes with "sum 3".
 So in dp = new Integer[coins.length][amount + 1];
See "Knapsack01.svg"


 * It is related to Unbounded Knapsack

 */
public class CoinChange2Memo {
    private Integer[][] dp;

    public int change(int amount, int[] coins) {
        // 0th col not used, as amount go from 1 to n
        dp = new Integer[coins.length][amount + 1];
        return coinPermutationCount(coins, amount, 0, coins.length);
    }

    public int coinPermutationCount(int[] coins, int sum, int index, int n) {
        if (sum == 0) return 1;
        if (sum < 0 || index == n) return 0;
        if (dp[index][sum] != null) return dp[index][sum];
        int left = coinPermutationCount(coins, sum - coins[index], index, n);
        int right = coinPermutationCount(coins, sum, index + 1, n);
        dp[index][sum] = left + right;
        return left + right;
    }
}
