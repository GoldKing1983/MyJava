package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/coin-change-2/description/
https://www.youtube.com/watch?v=jaNZ83Q3QGc
===========================================================Requirement===========================================================
1) Given an infinite supply of ‘n’ coin denominations and a total money amount,
2) We are asked to find the total number of distinct ways to make up that amount.
============================================================Example1=============================================================
Input: nums = [1,2,3], target = 4, Output: 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 3)
(2, 2)
============================================================Example2=============================================================
Input: candidates = [2,3,5], target = 8, Output: 3

The possible combination ways are:
  [2,2,2,2],
  [2,3,3],
  [3,5]
========================================================Solution Approach========================================================
1) If currentCoin == currentSum ...dp[currentSum] = dp[currentSum] + 1;
2) If currentCoin > currentSum ... no operation
3) If currentCoin < currentSum ... dp[currentSum] = dp[currentSum] + dp[currentSum-currentCoin]; 

Note: It is related to Unbounded Knapsack
=======================================================Data Flow Analysis========================================================

1 alone to make sum 1,2,3,4.
             0  1  2  3  4
            ===============
        {1} [0, 1, 1, 1, 1]
            
1 and 2 to make sum 1,2,3,4.(Use previous memoized value of 1)
             0  1  2  3  4
            ===============
        {1} [0, 1, 1, 1, 1]
      {1,2} [0, 1, 2, 2, 3]
            
1,2,3 to make sum 1,2,3,4.(Use previous memoized value of 1,2)
             0  1  2  3  4
            ===============
        {1} [0, 1, 1, 1, 1]
      {1,2} [0, 1, 2, 2, 3]
    {1,2,3} [0, 1, 2, 3, 4]
==================================================================================================================================
 */
public class CoinChange2DP {
  public int change(int target, int[] coins) {
    if (target == 0) return 1;

    int[] dp = new int[target + 1];
    for (int currentCoin : coins) {

      for (int currentSum = 1; currentSum <= target; currentSum++) {

        if (currentCoin == currentSum) dp[currentSum] = dp[currentSum] + 1;
        else if (currentCoin > currentSum) {
          // don't do anything. Previous value is good.
        } else dp[currentSum] = dp[currentSum] + dp[currentSum - currentCoin];
      }
    }
    return dp[target];
  }

}
