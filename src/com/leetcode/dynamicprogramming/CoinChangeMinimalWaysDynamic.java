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
=============================================================Theory Notes========================================================
Here the subProblem is individual coins to make the sum.
Ex: {2,3,6} sum=12
2 alone to make sum 12.
2 and 3 to make sum 12.(Use previous memoized value of 2)
2,3,6 to make sum. (Use previous memoized value of 2 and 3
===========================================================Solution Approach=====================================================
1) Use singleDimensionDp to track previousOutput.
2) If current coin is less than current amount, don't do anything. Previous Result will continue.
3) If current coin is equal to current amount, fill 1 in dp[currentAmount].
4) If current coin is greater than currentAmount,
            If dpPrevAmount is 0. continue. Because we cannot form output.
            If dpCurrAmount is 0. then dp[i] = dpPrevAmount+1
            Else dp[i] = Math.min(dpCurrAmount, dpPreviousAmoutPlus1);
===============================================================Data Flow Analysis================================================
	        0  1  2  3  4  5  6  7  8  9  10  11  12 ======P for Previous
	        ========================================
	 {2} || 0  0  1  0  2  0  3  0  4  0  5   0  6   	 ==> For 1 Coin --> {2}
   {2,4} || 0P 0P 1P 1P 1  0  2  0  2  0  3   0  3   	 ==> For 2 Coin --> {2,4}
 {2,4,6} || 0P 0P 1P 1P 1P 0P 1  0  2  0  2   0  2   	 ==> For 3 Coin --> {2,4,6}
============================================================= Why Math.min=======================================================
		input = [2,1] target= 5 ans=3 
		---------dp array, without math.min---------
		          0  1  2  3  4  5
		          =================  
		  {2} || [0, 0, 1, 0, 2, 0]
		{2,1} || [0, 1, 2, 3, 4, 5]
		
		Result(without Math.min) : 5

		---------below is dp array, if math.min is applied---------
                  0  1  2  3  4  5
                  =================  
        {2}   || [0, 0, 1, 0, 2, 0]
        {2,4} || [0, 1, 1, 2, 2, 3] ===> notice the change from 2nd row 2nd column

		
		

===========================
 */

public class CoinChangeMinimalWaysDynamic {
  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] dp = new int[amount + 1];
    for (int currentCoin : coins) {
      for (int i = currentCoin; i <= amount; i++) {
        if (i == currentCoin) {
          dp[i] = 1;
          continue;
        }

        int dpPrevAmount = dp[i - currentCoin];
        if (dpPrevAmount == 0) continue;

        int dpCurrAmount = dp[i];
        int dpPrevAmountPlus1 = dpPrevAmount + 1;

        if (dpCurrAmount == 0) dp[i] = dpPrevAmountPlus1;
        else dp[i] = Math.min(dpCurrAmount, dpPrevAmountPlus1);


      }
    }
    return dp[amount] != 0 ? dp[amount] : -1;
  }
}
