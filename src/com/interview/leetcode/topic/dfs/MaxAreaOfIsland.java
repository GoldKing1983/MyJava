package com.interview.leetcode.topic.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
/*

1) Instead of counting island in main(NumberOfIslands), count area inside bfs/dfs and keep maxAreaCount globally 
 */
public class MaxAreaOfIsland {
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int maxAreaOfIsland(int[][] grid) {
    int rowMax = grid.length;
    if (rowMax == 0) return 0;
    int colMax = grid[0].length;
    Deque<int[]> q = new ArrayDeque<>();

    int maxAreaCount = 0;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == 1) {
          currentAreaCount = 1;
          grid[row][col] = 0;
          q.add(new int[] {row, col});
          bfs(grid, q, rowMax, colMax);
          maxAreaCount = Math.max(maxAreaCount, currentAreaCount);
        }
      }
    }
    return maxAreaCount;
  }

  int currentAreaCount = 0;

  private void bfs(int[][] grid, Deque<int[]> q, int rowMax, int colMax) {

    while (!q.isEmpty()) {
      int[] point = q.poll();
      int row = point[0];
      int col = point[1];
      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];

        if (nextRow < 0 || nextCol < 0 || nextRow == rowMax || nextCol == colMax
            || grid[nextRow][nextCol] == 0) {
          continue;
        }
        grid[nextRow][nextCol] = 0;
        currentAreaCount++;
        q.add(new int[] {nextRow, nextCol});
      }
    }
  }

}
