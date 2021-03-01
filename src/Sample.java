

/*
com.interview.leetcode.topic.

===========================================================Requirement===========================================================
=========================================================Initial Thought=========================================================
===========================================================BruteForce============================================================
============================================================Example1=============================================================
========================================================Solution Approach========================================================
=======================================================Data Flow Analysis========================================================
=======================================================Logical Thinking==========================================================
=================================================================================================================================
 */
public class Sample {

  /*
   * 10,20,5 = 
   * 10,20,2
   * 
   */

  public int coinChange(int[] nums, int target) {
    Integer dp[][] = new Integer[nums.length+1][ target+1];
    int result = coinChange(nums, dp, target, 0, 0, nums.length);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public int coinChange(int[] coins, Integer[][] dp, int target, int index, int coinCount, int n) {
    if (target == 0) return coinCount;
    if (target < 0) return Integer.MAX_VALUE;
    if (index == n) return Integer.MAX_VALUE;
    if (dp[index][target] != null) return dp[index][target];
    int left = coinChange(coins, dp, target - coins[index], index, coinCount + 1, n);
    int right = coinChange(coins, dp, target, index + 1, coinCount, n);
    dp[index][target] = Math.min(left, right);
    return dp[index][target] ;
  }
}
