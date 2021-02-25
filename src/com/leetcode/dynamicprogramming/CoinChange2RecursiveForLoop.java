package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc

Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1



 * It is related to Unbounded Knapsack

 */
public class CoinChange2RecursiveForLoop {
    public int change(int amount, int[] coins) {
        return coinPermutationCount(coins, amount, 0, coins.length);
    }

    public int coinPermutationCount(int[] coins, int sum, int index, int n) {
        if (sum == 0) return 1;
        if (sum < 0 || index == n) return 0;
        int count = 0;
        while (index < n) {
            count += coinPermutationCount(coins, sum - coins[index], index, n);
            index++;
        }
        return count;
    }
}
