package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/minimum-path-sum/

Given a m x n grid filled with non-negative numbers, find a path from top left to
bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.



*/
public class MinimumPathSumRecursion {

  private int min = Integer.MAX_VALUE;

  public int minPathSum(int[][] grid) {
    minPathSum(grid, 0, 0, 0);
    return min;
  }

  public void minPathSum(int[][] grid, int row, int col, int total) {
    if (row == grid.length - 1 && col == grid[0].length) min = Math.min(min, total);
    else if (row < grid.length && col < grid[0].length) {

      minPathSum(grid, row, col + 1, total + grid[row][col]);

      minPathSum(grid, row + 1, col, total + grid[row][col]);
    }
  }
}
