package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/number-of-closed-islands/

Requirement : Find 0 surrounded by 1s (left, top, right, bottom).
=================================================================================================================================
Input:
[[0,0,1,0,0],
 [0,1,0,1,0],
 [0,0,1,0,0]]
Output:1
=================================================================================================================================
Input:
[[0,0,0,0,0],
 [0,1,0,1,0],
 [0,0,1,0,0]]
Output:0
=================================================================================================================================
[[1,1,1,1,1],
 [1,0,0,0,1],
 [1,0,0,0,1],
 [1,0,0,0,1],
 [1,1,1,1,1]]
 Output:1
=================================================================================================================================
[[1,1,1,1,1],
 [1,0,0,0,1],
 [1,0,1,0,1],
 [1,0,0,0,1],
 [1,1,1,1,1]]
 Output:1
=========Solution Approach - Flood Fill Algorithm==================================
1) See Picture "NumberOfClosedIslandsFloodFillAlgorithm.png".
2) Step1: Change all the corners and connected corners of 0s to 1.
3) Step2: When a 0 found then a closed island is found. Change all 0 connected 0 to 1.
=================================================================================================================================
 */
public class NumberOfClosedIslandsFloodFillAlgorithm {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int closedIsland(int[][] grid) {
    int res = 0;
    int rowMax = grid.length;
    int colMax = grid[0].length;
    // Step1
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (row == 0 || col == 0 || row == rowMax - 1 || col == colMax - 1 && grid[row][col] == 0) {
          recur(grid, row, col, rowMax, colMax);
        }
      }
    }
    // Step2
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == 0) {
          recur(grid, row, col, rowMax, colMax);
          res++;
        }
      }
    }
    return res;
  }

  private void recur(int[][] grid, int row, int col, int rMax, int cMax) {
    if (row == rMax || col == cMax || row < 0 || col < 0 || grid[row][col] == 1) return;
    grid[row][col] = 1;
    for (int i = 0; i < 4; i++) recur(grid, row + dirs[i][0], col + dirs[i][1], rMax, cMax);
  }
}
