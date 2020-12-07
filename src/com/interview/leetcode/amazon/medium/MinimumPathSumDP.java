package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/minimum-path-sum/
Similar to UniquePathsDP

Given a m x n grid filled with non-negative numbers, find a path from top left to
bottom right which minimizes the sum of all numbers along its path.

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

=========================================================Solution Approach=========================================================
1) fill first row by adding prev
2) fill first col by adding top
3) Rest Math.min(left, top) + current

See DP Matrix below:

       0 1 2
       =======
  0 || 1 4 5
  1 || 2 7 6
  2 || 6 8 7

*/
public class MinimumPathSumDP {

  public int minPathSum(int[][] grid) {
    int maxRow = grid.length, maxCol = grid[0].length;
    int[][] dp = new int[maxRow][maxCol];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < maxCol; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];

    for (int i = 1; i < maxRow; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];

    for (int i = 1; i < maxRow; i++) {
      for (int j = 1; j < maxCol; j++) dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
    }
    return dp[maxRow - 1][maxCol - 1];
  }
}
