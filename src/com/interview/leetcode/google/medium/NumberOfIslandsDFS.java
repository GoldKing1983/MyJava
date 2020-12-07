package com.interview.leetcode.google.medium;

/*
	https://leetcode.com/problems/number-of-islands/

1) Start from 0,0. If it is "1". Call the recursion.
2) How many time loop runs to call recursion is counted as result.
3) Inside Recursion:
	3a) Recurse in 4 direction.
	3b) BackTracking not needed.
	3c) Note data is corrupted or all the 1's are turned into 0.
	3d) visited logic is handled by "grid[row][col] == '0'".
	ie. When going from "pointA" to "pointB", "pointA" is set to "0". if any point is "0" it is considered visited.

 */
public class NumberOfIslandsDFS {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int numIslands(char[][] grid) {
    int islandCount = 0;
    int rowMax = grid.length;
    if (rowMax == 0) return 0;
    int colMax = grid[0].length;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == '1') {
          grid[row][col] = '0';
          islandCount++;
          recur(grid, row, col, rowMax, colMax);
        }
      }
    }
    return islandCount;
  }

  private void recur(char[][] grid, int row, int col, int rowMax, int colMax) {
    for (int i = 0; i < 4; i++) {
      int nextRow = row + DIRECTIONS[i][0];
      int nextCol = col + DIRECTIONS[i][1];
      if (nextRow == rowMax || nextCol == colMax || nextRow < 0 || nextCol < 0) continue;
      if (grid[nextRow][nextCol] == '0') continue;
      grid[nextRow][nextCol] = '0';
      recur(grid, nextRow, nextCol, rowMax, colMax);
    }
  }
}
