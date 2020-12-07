package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.

Input: amount = 5, coins = [1, 2, 5]
Output: 4

[5]
[]
[2]
[2, 2]
[2, 2, 2]
[2, 2]
[2, 2, 1]
[2, 2]
[2]
[2, 1]
[2, 1, 1]
[2, 1, 1, 1]
[2, 1, 1]
[2, 1]
[2]
[]
[1]
[1, 1]
[1, 1, 1]
[1, 1]
[1]
[]




 * It is related to Unbounded Knapsack

 */
public class CoinChange2RecursiveForLoopImproved {
  private Integer[][] dp;

  public int change(int amount, int[] coins) {
    int n = coins.length;
    dp = new Integer[n + 1][amount + 1];
    Arrays.sort(coins);
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      int temp = coins[i];
      coins[i] = coins[j];
      coins[j] = temp;
    }
    return coinPermutationCount(coins, new ArrayList<>(), amount, 0);
  }

  public int coinPermutationCount(int[] coins, List<Integer> list, int sum, int index) {
    if (sum == 0) return 1;
    if (sum < 0 || index == coins.length) return 0;
    if (dp[index][sum] != null) return dp[index][sum];
    int count = 0;
    for (int i = index; i < coins.length; i++) {
      list.add(coins[i]);
      System.out.println(list);
      count += coinPermutationCount(coins, list, sum - coins[i], i);
      list.remove(list.size() - 1);
      System.out.println(list);
      dp[index][sum] = count;
    }
    return count;
  }
}
