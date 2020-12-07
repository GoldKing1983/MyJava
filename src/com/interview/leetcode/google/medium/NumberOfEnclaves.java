package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/number-of-enclaves/
=================================================================================================================================
Requirement:
1) Given a 2D array, each cell is 0 (representing sea) or 1 (representing land)
2) A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
3) Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
=================================================================================================================================
Input:
[[0,0,0,0],
 [1,0,1,0],
 [0,1,1,0],
 [0,0,0,0]]
Output: 3
Explanation:
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
=================================================================================================================================
Input:
[[0,1,1,0],
 [0,0,1,0],
 [0,0,1,0],
 [0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
=========Solution Approach - Flood Fill Algorithm==================================
1) See Picture "NumberOfEnclaves.png.png".
2) Step1: Change all the corners and connected corners of 1s to 0.
3) Step2: For all 1 in grid, increase result count.
=================================================================================================================================

 */
public class NumberOfEnclaves {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int numEnclaves(int[][] grid) {
    int res = 0;
    int rowMax = grid.length;
    int colMax = grid[0].length;
    // Step1
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (row == 0 || col == 0 || row == rowMax - 1 || col == colMax - 1 && grid[row][col] == 1) {
          recur(grid, row, col, rowMax, colMax);
        }
      }
    }
    // Step2
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == 1) res++;
      }
    }
    return res;
  }

  private void recur(int[][] grid, int row, int col, int rMax, int cMax) {
    if (row == rMax || col == cMax || row < 0 || col < 0 || grid[row][col] == 0) return;
    grid[row][col] = 0;
    for (int i = 0; i < 4; i++) recur(grid, row + dirs[i][0], col + dirs[i][1], rMax, cMax);
  }
}
