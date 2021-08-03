package com.interview.leetcode.linkedin.medium;

/*
===========================================================Requirement===========================================================
https://leetcode.com/problems/combination-sum-iv
1) Given an array of distinct integers nums and a target, 
2) Return the number of possible combinations that add up to target.
============================================================Example1=============================================================
Input: nums = [1,2,3], target = 4, Output: 7

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
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
=======================================================Data Flow Analysis========================================================
1) This problem is same as CoinChange2DP. We change only the loop. Understand that problem first.
2) Here since duplicates are allowed. There will be more resultCount. 
3) At each iteration we change(update) only 1 column. So the resultCount grows allowing duplicates. 
4) It is tricky to understand, how duplicated is counted here and duplicate is ignored in CoinChange2DP.


Input: nums = [1,2,3], target = 4, Output: 7

1,2,3 to make sum 1.
			 0  1  2  3  4
			===============
	{1,2,3}	[0, 1, 0, 0, 0]
			
1,2,3 to make sum 2.(Use previous memoized value of 1)
             0  1  2  3  4
            ===============
    {1,2,3} [0, 1, 1, 1, 1]
    {1,2,3} [0, 1, 2, 0, 0]
			
1,2,3 to make sum 3.(Use previous memoized value of 1,2)
             0  1  2  3  4
            ===============
    {1,2,3} [0, 1, 1, 1, 1]
    {1,2,3} [0, 1, 2, 0, 0]
    {1,2,3} [0, 1, 2, 4, 0]

1,2,3 to make sum 4.(Use previous memoized value of 1,2,3)
             0  1  2  3  4
            ===============
    {1,2,3} [0, 1, 1, 1, 1]
    {1,2,3} [0, 1, 2, 0, 0]
    {1,2,3} [0, 1, 2, 4, 0]
    {1,2,3} [0, 1, 2, 4, 7]
  
 */
public class CombinationSumIVDp {

  public int combinationSum4(int[] coins, int target) {
    int[] dp = new int[target + 1];
    for (int currentSum = 1; currentSum <= target; currentSum++) {
      for (int currentCoin : coins) {
        if (currentCoin == currentSum) dp[currentSum] = dp[currentSum] + 1;
        else if (currentCoin > currentSum) {
          // don't do anything. Previous value is good.
        } else dp[currentSum] = dp[currentSum] + dp[currentSum - currentCoin];
      }
    }
    return dp[target];
  }
}
