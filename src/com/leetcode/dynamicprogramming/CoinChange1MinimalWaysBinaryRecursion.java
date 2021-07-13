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
=================================================Solution Approach - Not Optimal=================================================
1) Memoization of this problem is tricky. Don't waste time.
2) See https://leetcode.com/problems/coin-change/discuss/77368/*Java*-Both-iterative-and-recursive-solutions-with-explanations/191079
Above particular thread talks about various person tried below approach and when they tried memoize all got TLE. 
 */
public class CoinChange1MinimalWaysBinaryRecursion {
  public int coinChange(int[] nums, int target) {
    int result = coinChange(nums, target, 0, 0, nums.length);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public int coinChange(int[] coins, int target, int index, int coinCount, int n) {
    if (target == 0) return coinCount; // Found a solution. Return the count.
    if (target < 0) return Integer.MAX_VALUE; // Negative coin is not possible. So return
    if (index == n) return Integer.MAX_VALUE; // reached beyond lastCoin... Nothing to go further. So return
    int left = coinChange(coins, target - coins[index], index, coinCount + 1, n); // keepTheSameCoin and go further
    int right = coinChange(coins, target, index + 1, coinCount, n);//goForNextCoin
    return Math.min(left, right);
  }
}
