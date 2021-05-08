package com.interview.leetcode.topic.dp;

/*
Based on Bounded(0/1) KnapSack.
https://www.youtube.com/watch?v=K20Tx8cdwYY

S--> Same, P--> Previous

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||false, false,  false, false, false, false, false
{0,1}		||false, trueS,  false, false, false, false, false

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||false, false,  false, false, false, false, false
{0,1}		||false, true,  false, false, false, false, false
{0,1,2}		||false, trueP,  trueS, true1,  false, false, false

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||false, false,  false, false, false, false, false
{0,1}		||false, true,  false, false, false, false, false
{0,1,2}		||false, true,  true,  true,  false, false, false
{0,1,2,3}	||false, trueP, trueP, trueS, true1, true2, true3

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||false, false,  false, false, false, false, false
{0,1}		||false,  true,   false, false, false, false, false
{0,1,2}		||false,  true,    true,  true, false, false, false
{0,1,2,3}	||false,  true,    true,  true,  true,  true,  true
{0,1,2,3,4}	||false,  trueP,  trueP, trueP, trueS, true1, true2

==============================================================Solution Approach==================================================
1) dp = new boolean[n + 1][target + 1]. Because we skip 0thRow and 0thCol
2) Run Outer Loop from 1 to n.
3) Run Inner Loop from 1 to target or availableNumbers.
      ==============Main Logic==============
4) if currentNumberAddedToSack == currentRunningNumber(col).. dp[row][col] = true
5) If currentNumberAddedToSack  > currentRunningNumber(col).. dp[row][col] = previousRow
6) If currentNumberAddedToSack  < currentRunningNumber(col).. dp[row][col] = previousRow or previousRowNegatedNumber
=================================================================================================================================
 */
public class GroupSumDP {

  public boolean groupSum(int[] nums, int target) {
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][target + 1];
    for (int row = 1; row <= n; row++) {
      int currentNumberAddedToSack = nums[row - 1];
      for (int col = 1; col <= target; col++) {
        if (currentNumberAddedToSack == col) {
          dp[row][col] = true;
        } else if (currentNumberAddedToSack > col) {
          // Fill from previous row.
          dp[row][col] = dp[row - 1][col];
        } else { // if (currentNumberAddedToSack < col)
          // Fill from previousRow or previousRowNegatedColumn
          dp[row][col] = dp[row - 1][col] || dp[row - 1][col - currentNumberAddedToSack];
        }
      }
    }
    return dp[n][target];
  }
}
