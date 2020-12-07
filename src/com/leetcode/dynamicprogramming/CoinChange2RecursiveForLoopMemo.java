package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.

Input: amount = 5, coins = [1, 2, 5]
Output: 4

[1]
[1, 1]
[1, 1, 1]
[1, 1, 1, 1]
[1, 1, 1, 1, 1] --> Output1
[1, 1, 1, 1]
[1, 1, 1, 1, 2]
[1, 1, 1, 1]
[1, 1, 1, 1, 5]
[1, 1, 1, 1]
[1, 1, 1]
[1, 1, 1, 2] --> Output2
[1, 1, 1]
[1, 1, 1, 5]
[1, 1, 1]
[1, 1]
[1, 1, 2]
[1, 1, 2, 2]
[1, 1, 2]
[1, 1, 2, 5]
[1, 1, 2]
[1, 1]
[1, 1, 5]
[1, 1]
[1]
[1, 2]
[1, 2, 2] --> Output3
[1, 2]
[1, 2, 5]
[1, 2]
[1]
[1, 5]
[1]
[]
[2]
[2, 2]
[2]
[2, 5]
[2]
[]
[5]  --> Output4
[]



 * It is related to Unbounded Knapsack

 */
public class CoinChange2RecursiveForLoopMemo {
  private Integer[][] dp;

  public int change(int amount, int[] coins) {
    dp = new Integer[coins.length + 1][amount + 1];
    return coinPermutationCount(coins, amount, 0);
  }

  public int coinPermutationCount(int[] coins, int sum, int index) {
    if (sum == 0) return 1;
    if (sum < 0 || index == coins.length) return 0;
    if (dp[index][sum] != null) return dp[index][sum];
    int count = 0;
    for (int i = index; i < coins.length; i++) {
      count += coinPermutationCount(coins, sum - coins[i], i);
      dp[index][sum] = count;
    }
    return count;
  }
}
