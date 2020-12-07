package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc
=================================================Requirement===============================================================
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
=============================================================================================================================
 1) It is related to Unbounded Knapsack
 2) Filling the "first row", "first column" is the key to the solution i.e dp[0] = 1
 It means, I can "form 0", with no coin.
========================================Solution Approach======================================================================
1) We don't need 2 dimensional array, since we can retrieve both current value and previous value from same row.
2) For each of coin do ==> dp[i] = currentCoinResult + previousCoinResult;
==============================P for Previous Value UnTouched =================================================================
 		    0    1   2   3   4   5  6  7  8  9 10  11 12
 		    ============================================
    {0} || [1,   0,  0,  0,  0,  0, 0, 0, 0, 0, 0, 0, 0] ==> For 0 Coin 		    
	{2}	|| [1,   0,  1,  0,  1,  0, 1, 0, 1, 0, 1, 0, 1] ==> For 1 Coin
  {2,4}	|| [1P, 1P, 1P, 1P,  2,  0, 2, 0, 3, 0, 3, 0, 4] ==> For 2 Coin
{2,4,6} || [1P, 1P, 1P, 1P, 2P, 2P, 3, 0, 4, 0, 5, 0, 7] ==> For 3 Coin

===============Possible Combination for above input==============================================================================
2,2,2,2,2,2
2,2,2,2,4
2,2,2,6
2,2,4,4
2,4,6
4,4,4
6,6
==================================================================================================================================
 */
public class CoinChange2 {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; ++i) {
        int currentCoinResult = dp[i];
        int previousCoinResult = dp[i - coin];
        dp[i] = currentCoinResult + previousCoinResult;
      }
    }
    return dp[amount];
  }
}
