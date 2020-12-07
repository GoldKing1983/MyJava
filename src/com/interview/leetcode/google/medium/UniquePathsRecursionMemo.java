package com.interview.leetcode.google.medium;

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
============================Solution Approach==============================================================
1) Look into picture "UniquePaths.png".

 */
public class UniquePathsRecursionMemo {
  public int uniquePaths(int m, int n) {
    int[][] cache = new int[m][n];
    return uniquePathsHelper1(1, 1, cache.length, cache[0].length, cache);
  }

  private int uniquePathsHelper1(int row, int col, int maxRow, int maxCol, int[][] cache) {
    if (row == maxRow || col == maxCol) return 1;
    if (cache[row][col] > 0) return cache[row][col];
    int fromTop = uniquePathsHelper1(row + 1, col, maxRow, maxCol, cache);
    int fromLeft = uniquePathsHelper1(row, col + 1, maxRow, maxCol, cache);
    cache[row][col] = fromTop + fromLeft;
    return cache[row][col];
  }
}
