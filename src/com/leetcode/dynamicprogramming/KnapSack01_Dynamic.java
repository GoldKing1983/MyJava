package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/*

https://www.youtube.com/watch?v=sVAB0p58tlg

Each item can only be selected once

=====================================================================================
Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

 				0	1	2	3	4	5
				==========================
	{0}		 ||	0	0	0	0	0	0
	{2}		 ||	0	0	0	0	0	0
	{2,3}	 || 0	0	0	0	0	0
	{2,3,1}  || 0	0	0	0	0	0
	{2,3,1,4}||	0	0	0	0	0	0

		For {2} alone
 				0	1	2	3	4	5
				==========================
	{2}		 ||	0	0	4	4	4	4
	{2,3}	 || 0	0	0	0	0	0
	{2,3,1}  || 0	0	0	0	0	0
	{2,3,1,4}||	0	0	0	0	0	0

		For {2,3}
 				0	1	2	3	4	5
				==========================P for Previous Weight
	{2}		 ||	0	0	4	4	4	4
	{2,3}	 || P	P	4P	5	5	9
	{2,3,1}  || 0	0	0	0	0	0
	{2,3,1,4}||	0	0	0	0	0	0

		For {2,3,1} alone
 				0	1	2	3	4	5
				==========================
	{2}		 ||	0	0	4	4	4	4
	{2,3}	 || P	P	4P	5	5	9
	{2,3,1}  || 0	3	4	7	8	9
	{2,3,1,4}||	0	0	0	0	0	0

        For {2,3,1,4} alone
                0   1   2   3   4   5
                ==========================
    {2}      || 0   0   4   4   4   4
    {2,3}    || P   P   4P  5   5   9
    {2,3,1}  || 0   3   4   7   8   9
    {2,3,1,4}|| 0   3   4   7   8   10
=====================================================================================
		int weightValues[] = new int[] { 60, 100, 120 };
		int weights[] = new int[] { 1, 2, 3 };
		int knapSackWeight = 5;

		0   1   2    3    4    5
		==========================
{0}		[0, 0,  0,   0,   0,   0]
{1}		[0, 60, 60,  60,  60,  60]
{1,2}	[0, 60, 100, 160, 160, 160]
{1,2,3}	[0, 60, 100, 160, 180, 220]
==============================
currentWeight = weight newly added to set
condition 1) currentWeight equals indexWeight --> Math.max(previousWeightValues, currentWeightValues)
condition 2) currentWeight greater than indexWeight -->  fill previousWeightValues.
condition 3) currentWeight less than indexWeight --> Math.max(currentWeightValues+previousNegatedWeightValue, previousWeightValues)
======implementation note======
1) j starts from 1 and not i. Because we need to fill previousWeightValues for that row.
So condition 2 will be the case from 1 to i.
2) Solving this problem in 1 dimensional array is tricky
==========

 */
public class KnapSack01_Dynamic {

  // Returns the maximum value that can be put in a knapsack of capacity W
  static int knapSack(int knapSackWeight, int weights[], int weightValues[], int n) {
    int dp[][] = new int[n + 1][knapSackWeight + 1];
    // Start from 1st row and 1st column. Entire 0th row and each rows 0th column always contains 0.
    for (int i = 1; i <= n; i++) {
      int currentWeight = weights[i - 1];
      int currentWeightValue = weightValues[i - 1];

      for (int j = 1; j <= knapSackWeight; j++) {
        int previousWeightValue = dp[i - 1][j];
        if (currentWeight == j) {
          dp[i][j] = Math.max(currentWeightValue, previousWeightValue);
        } else if (currentWeight > j) {
          dp[i][j] = previousWeightValue;
        } else { // currentWeight < j
          int previousNegatedWeightValue = dp[i - 1][j - currentWeight];
          dp[i][j] = Math.max(currentWeightValue + previousNegatedWeightValue, previousWeightValue);
        }
      }
      System.out.println(Arrays.toString(dp[i]));
    }

    return dp[n][knapSackWeight];
  }

  // Driver program to test above function
  public static void main(String args[]) {
    int[] weights = new int[] {2, 3, 1, 4};
    int[] weightValues = new int[] {4, 5, 3, 7};
    int n = weightValues.length;
    System.out.println(knapSack(5, weights, weightValues, n));
    // System.out.println(knapSack(6, weights, weightValues, n));
  }
}
