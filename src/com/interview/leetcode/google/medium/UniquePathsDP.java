package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/unique-paths/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the
bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
==========================================================================================
Example 1:

Input: m = 3, n = 3
Output: 6
			x	x	x
			x	x	x
			x	x	x

			[1, 1, 1]
			[1, 2, 3]
			[1, 3, 6]
============================Solution Approach======Look into picture "UniquePaths.png".=============================
1) Fill first row of DP with 1.
2) Fill first column of DP with 1.
3) Rest of DP, formula is dp[i][j] = fromTop + fromLeft;


 */
public class UniquePathsDP {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    Arrays.fill(dp[0], 1); // Fill First Row with 1
    for (int i = 0; i < m; i++) dp[i][0] = 1; // Fill First Col with 1
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        int fromTop = dp[i - 1][j];
        int fromLeft = dp[i][j - 1];
        dp[i][j] = fromTop + fromLeft;
      }
    }
    return dp[m - 1][n - 1];
  }
}
