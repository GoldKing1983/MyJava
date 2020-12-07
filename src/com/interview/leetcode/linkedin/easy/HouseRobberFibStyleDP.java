package com.interview.leetcode.linkedin.easy;

/*

Requirement: Out of "N" houses, thief cannot stole from two adjacent houses.
=============================================Solution Approach=============================================
f(n) = Math.max(f(n-2)+f(n),f(n-1))

1) If there are 1 house to rob, then max benefit would be f(n)
2) If there are 2 house to rob, then max benefit would be Max of "f(n)", "f(n-1)"
3) If there are 3 house to rob, then max benefit would be Max of "f(n)+f(n-2)", "f(n-1)"...
	  Rob "house1 and house3" or "house1" alone. Max benefit is whichever is max

Thats it, code for the formula
=========================================================================================================
Ex1: [100] 		    Ans:100
Ex1: [100, 2]       Ans:100
Ex1: [100,2,3]  	Ans:103
Ex1: [100,2,3,50]  	Ans:150 dp[100,100,103,150]

 */

public class HouseRobberFibStyleDP {
  public int rob(int[] wealth) {
    int totalHouse = wealth.length;
    if (totalHouse == 0) return 0;
    if (totalHouse == 1) return wealth[0];

    int[] dp = new int[totalHouse];
    dp[0] = wealth[0];
    dp[1] = Math.max(wealth[0], wealth[1]);

    for (int i = 2; i < totalHouse; i++) {
      dp[i] = Math.max(dp[i - 1], wealth[i] + dp[i - 2]);
    }
    return dp[totalHouse - 1];
  }

  public int robFibonacciStyle(int[] nums) {
    int fN = 0;
    int fNMinus1 = 0;
    int fNMinus2 = 0;
    for (int num : nums) {
      fN = Math.max(fNMinus2 + num, fNMinus1);
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fN;
  }
}
