package com.interview.leetcode.google.hard;

/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 Requirement: Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
==============================================================================================================
Example 1:
Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
==============================================================================================================
Example 2:
Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
=======================================Solution Approach============================================================
1) Recurse in 4 direction for a point. If the left/right/up/down value is greater than current. Increment the length.
2) Decrement the length will also work. Because. 1,2,3,4 or 4,3,2,1 both yields size 4.
====================================================================================================================
Time complexity : O(2^{m+n})
Space complexity : O(mn)
====================================================================================================================
 */
public class LongestIncreasingPathInAMatrix {
  int maxRow;
  int maxCol;
  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};

  public int longestIncreasingPath(int[][] matrix) {
    int[] max = new int[1];
    maxRow = matrix.length;
    if (maxRow == 0) return 0;
    maxCol = matrix[0].length;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        dfs(matrix, i, j, max, 1);
      }
    }
    return max[0];
  }

  public void dfs(int[][] matrix, int row, int col, int[] max, int len) {
    max[0] = Math.max(max[0], len);
    for (int i = 0; i < 4; i++) {
      int x = row + dx[i];
      int y = col + dy[i];
      if (x >= 0 && x < maxRow && y >= 0 && y < maxCol && matrix[x][y] > matrix[row][col]) {
        dfs(matrix, x, y, max, len + 1);
      }
    }
  }
}
