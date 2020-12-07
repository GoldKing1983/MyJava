package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/perfect-squares/

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

==============================================Solution Approach==============================================

1) Candidate for the amount is currentCoin*currentCoin. So candidate would be 1,4,9,16.....
		1*1 = 1
		2*2 = 4
		3*3 = 9
		4*4 = 16


 */
public class PerfectSquaresCoinChangeBetter {
  public int numSquares(int amount) {
    int[] dp = new int[amount + 1];
    int currentCoin = 0;
    for (int currentCoinBase = 1; currentCoin <= amount; currentCoinBase++) {
      currentCoin = currentCoinBase * currentCoinBase;
      for (int i = currentCoin; i <= amount; i++) {
        if (i == currentCoin) dp[i] = 1;
        else if (dp[i - currentCoin] != 0) {
          int dpPreviousAmoutPlus1 = dp[i - currentCoin] + 1;
          dp[i] = dp[i] == 0 ? dpPreviousAmoutPlus1 : Math.min(dp[i], dpPreviousAmoutPlus1);
        }
      }
    }

    return dp[amount] != 0 ? dp[amount] : -1;
  }
}
