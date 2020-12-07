package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
	https://leetcode.com/problems/number-of-islands/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

1) Start from 0,0. If it is "1". Call the bfs.
2) How many time loop runs to call bfs is counted as result.
3) Inside BFS:
	3a) Recurse in 4 direction.
	3b) Note data is corrupted or all the 1's are turned into 0.
	3c) visited logic is handled by "grid[row][col] == '0'".
	ie. When going from "pointA" to "pointB", "pointA" is set to "0". if any point is "0" it is considered visited.

 */
public class NumberOfIslandsBFS {
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int numIslands(char[][] grid) {
    int rowMax = grid.length;
    if (rowMax == 0) return 0;
    int colMax = grid[0].length;
    int isLandCount = 0;
    Deque<int[]> q = new ArrayDeque<>();

    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == '1') {
          grid[row][col] = '0';
          q.add(new int[] {row, col});
          bfs(grid, q, rowMax, colMax);
          isLandCount++;
        }
      }
    }
    return isLandCount;
  }

  private void bfs(char[][] grid, Deque<int[]> q, int rowMax, int colMax) {

    while (!q.isEmpty()) {
      int[] point = q.poll();
      int row = point[0];
      int col = point[1];
      for (int[] direction : DIRECTIONS) {
        int nextRow = row + direction[0];
        int nextCol = col + direction[1];

        if (nextRow < 0
            || nextCol < 0
            || nextRow == rowMax
            || nextCol == colMax
            || grid[nextRow][nextCol] == '0') {
          continue;
        }
        grid[nextRow][nextCol] = '0';
        q.add(new int[] {nextRow, nextCol});
      }
    }
  }
}
