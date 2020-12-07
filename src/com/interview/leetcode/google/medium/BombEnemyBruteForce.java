package com.interview.leetcode.google.medium;

/*
* https://leetcode.com/problems/bomb-enemy/

For each '0', if E found vertically/horizontally increment count. Cache maxCount.
*/
public class BombEnemyBruteForce {
  public int maxKilledEnemies(char[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '0') recur(grid, i, j);
      }
    }
    return maxCount;
  }

  int maxCount = 0;

  private void recur(char[][] grid, int row, int col) {
    int currentCount = 0;
    for (int i = row; i < grid.length; i++) {
      if (grid[i][col] == 'W') break;
      if (grid[i][col] == 'E') currentCount++;
    }
    for (int i = row; i >= 0; i--) {
      if (grid[i][col] == 'W') break;
      if (grid[i][col] == 'E') currentCount++;
    }
    for (int i = col; i < grid[0].length; i++) {
      if (grid[row][i] == 'W') break;
      if (grid[row][i] == 'E') currentCount++;
    }
    for (int i = col; i >= 0; i--) {
      if (grid[row][i] == 'W') break;
      if (grid[row][i] == 'E') currentCount++;
    }
    maxCount = Math.max(currentCount, maxCount);
  }
}
