package com.leetcode.dynamicprogramming;

/*
 * https://www.youtube.com/watch?v=K20Tx8cdwYY
 *

S--> Same, P--> Previous

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||true, false,  false, false, false, false, false
{0,1}		||true, trueS,  false, false, false, false, false

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||true, false,  false, false, false, false, false
{0,1}		||true, true,  false, false, false, false, false
{0,1,2}		||true, trueP,  trueS, true1,  false, false, false

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||true, false,  false, false, false, false, false
{0,1}		||true, true,  false, false, false, false, false
{0,1,2}		||true, true,  true,  true,  false, false, false
{0,1,2,3}	||true, trueP, trueP, trueS, true1, true2, true3

				0	  1		 2		3	  4		  5		6
			================================================
{0}			||true, false,  false, false, false, false, false
{0,1}		||true,  true,   false, false, false, false, false
{0,1,2}		||true,  true,    true,  true, false, false, false
{0,1,2,3}	||true,  true,    true,  true,  true,  true,  true
{0,1,2,3,4}	||true,  trueP,  trueP, trueP, trueS, true1, true2

==============================================================Solution Approach==================================================
0) dp = new boolean[n + 1][target + 1]. Because we skip 0thRow and target(col) start from 1.
1) Fill first column with true.
2) Run Outer Loop from 1 to n.
3) Run Inner Loop from 1 to target.
4) Fill the dp[row][col] from previousRow.
5) if currentRunningNumber(col) == currentNumber dp[row][col] == true
6) If dp[row][col] == true loop can continue. Because all we try is to set true.
7) If currentRunningNumber >= currentNumber. dp[row][col] = previousRowNegatedNumber
=================================================================================================================================
 */
public class GroupSumDP {

  public boolean groupSum(int[] nums, int target) {
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][target + 1];

    // Set first column to true
    for (int i = 0; i <= n; i++) dp[i][0] = true;

    for (int row = 1; row <= n; row++) {
      int currentNumber = nums[row - 1];
      for (int col = 1; col <= target; col++) {
        dp[row][col] = dp[row - 1][col]; // Fill from previous row.

        if (col == currentNumber) dp[row][col] = true;

        if (dp[row][col]) continue;

        if (col > currentNumber) {
          dp[row][col] = dp[row - 1][col - currentNumber];
        }
      }
    }

    return dp[n][target];
  }
}
