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
========================================================Logical Thinking=========================================================
1) If there is only 1 row. Answer is sum of left to right.
2) If there is only 1 col. Answer is sum of top to bottom.
3) If I eagerly, move by selecting best path. Then answer may go wrong. Ex:
        1,1,100
        2,3,1
4) BruteForce Solution is recurse all possible combination path(leftToRight and bottomToTop only).
5) Memoize the
=========================================================Solution Approach=======================================================
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
        // fill first row
        for (int row = 1; row < maxRow; row++) dp[row][0] = dp[row - 1][0] + grid[row][0];

        // fill first col
        for (int col = 1; col < maxCol; col++) dp[0][col] = dp[0][col - 1] + grid[0][col];

        for (int row = 1; row < maxRow; row++) {
            for (int col = 1; col < maxCol; col++) {
                dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[maxRow - 1][maxCol - 1];
    }
}
