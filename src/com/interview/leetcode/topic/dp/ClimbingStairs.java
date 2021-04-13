package com.interview.leetcode.topic.dp;

/*
https://leetcode.com/problems/climbing-stairs/description/
https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
===========================================================Requirement===========================================================
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

On analyzing the result, solution is based on Fibonacci Series
============================================================Example1=============================================================
   Example: if number of step is 3. I can code below.

   f(n) = f{ (n-1) + (n-2)}
  n  =	0	1	2	3	4	5	6	7	8	9	10	11	12	13	...
f(n) =	0	1	2	3	5	8	13	21	34	55	89	144	233	377	...
Comparing to fibonacci... for 2 here output is 2. In fibonacci it is 1. Consecutive formulas and approaches are same.

But to generalize to any steps. for loop is best approach.
=================================================================================================================================
*/

public class ClimbingStairs {

  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    return fib(n, dp);
  }

  public int fib(int n, int[] dp) {
    if (n <= 2) return n;
    if (dp[n] == 0) dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    return dp[n];
  }

  int climbingStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int climbStairsFibo(int n) {
    if (n <= 1) return n;
    int fN = 1;
    int fNMinus1 = 1;
    int fNMinus2 = 0;
    for (int i = 1; i <= n; i++) {
      fN = fNMinus1 + fNMinus2;
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fN;
  }
}
