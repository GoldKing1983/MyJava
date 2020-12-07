package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/unique-paths-ii/
=========================================================Requirement=============================================================
A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid.

Now consider if some obstacles are added to the grids. How many unique paths would there be?

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
Path1: Right -> Right -> Down -> Down
Path2: Down -> Down -> Right -> Right

Input: [[1]] Output: 0

Input:
[[0,0],
 [1,1],
 [0,0]]
 Output:0
==========================================================Solution Approach=====================================================
Solution based on extension of UniquePathsDP. So understand UniquePathsDP first.
1) When filling 1st row and 1st column, if there is a obstacle, break. Because robot cannot move further.
2) When filling dp if there is a obstacle, continue.
3) Rest of logic same as UniquePathsDP
================================================================================================================================
 */
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int maxRow = obstacleGrid.length;
    int maxCol = obstacleGrid[0].length;
    int[][] dp = new int[maxRow][maxCol];
    // Fill first Row of DP
    for (int i = 0; i < maxCol; i++) {
      if (obstacleGrid[0][i] == 1) break;
      dp[0][i] = 1;
    }
    // Fill first Column of DP
    for (int i = 0; i < maxRow; i++) {
      if (obstacleGrid[i][0] == 1) break;
      dp[i][0] = 1;
    }
    // Fill rest of Column of DP
    for (int i = 1; i < maxRow; i++) {
      for (int j = 1; j < maxCol; j++) {
        if (obstacleGrid[i][j] == 1) continue;
        int fromTop = dp[i - 1][j];
        int fromLeft = dp[i][j - 1];
        dp[i][j] = fromTop + fromLeft;
      }
    }

    return dp[maxRow - 1][maxCol - 1];
  }
}
