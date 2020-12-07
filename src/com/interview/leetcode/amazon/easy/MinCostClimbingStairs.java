package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/min-cost-climbing-stairs/description/
https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
==================================================Requirement==================================================
"There will be minimum 2 steps."
1) Initially you can reach step1(index0) or step2(index1) with 0 cost.
2) From there onwards, 2 moves are possible. Can jump one step or jump 2 step by paying cost at that step.
3) The problem is about reaching the n+1 step with minimal cost. So loop has to start from 0 to n rather n-1.

===============================================Solution Approach================================================
We need to return dp(n+1)
dp(i) = cost[i]+min(dp(i-1), dp(i-2))
dp(n+1) = Math.min(dp(n), dp(n-1))



Ex1: [10, 15]     ==> dp[0] =10,
					  dp[1] = 15,
			 dp(n+1) = Ans= Math.min(10,15) = 10

Ex2: [10, 15, 20] ==> dp[0] =10,
					  dp[1] = 15,
			 dp(n)	= dp[2] = Math.min(10, 15) + 20 = 30.
			 dp(n+1) = Ans= Math.min(30,15) = 15

 */
public class MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] nums) {
    int n = nums.length - 1;
    int[] dp = new int[n + 1];
    dp[0] = nums[0];
    dp[1] = nums[1];
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.min(nums[i] + dp[i - 1], nums[i] + dp[i - 2]);
    }
    return Math.min(dp[n], dp[n - 1]);
  }
}
