package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/min-cost-climbing-stairs/description/
https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning
==================================================Requirement==================================================
"There will be minimum 2 steps."
1) Initially you can reach step1(index0) or step2(index1) at the cost of their index.
2) From there onwards, 2 moves are possible. Can jump one step or jump 2 step by paying cost at landing index.

===============================================Solution Approach================================================

Ex1: [10, 15]     ==> dp[0] =10,
					  dp[1] = 15,
			             Ans= Math.min(10,15) = 10

Ex2: [10, 15, 20] ==> dp[0] =10,
					  dp[1] = 15,
			          dp[2] = Math.min(10, 15) + 20 = 30.
			             Ans= Math.min(30,15) = 15

 */
public class MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n];
    // Ex: [15,10] output:10
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < n; i++) {
      dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    }
    return Math.min(dp[n - 1], dp[n - 2]);
  }
}
