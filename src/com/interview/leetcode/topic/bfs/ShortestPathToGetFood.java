package com.interview.leetcode.topic.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/shortest-path-to-get-food

    [["X","X","X","X","X","X"],
     ["X","*","O","O","O","X"],
     ["X","O","O","#","O","X"],
     ["X","X","X","X","X","X"]]

Output: 3
Explanation: Starting the traversal from '*'. It takes 3 steps to reach the food.

*/

public class ShortestPathToGetFood {
  int[][] DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int getFood(char[][] grid) {
    int maxRow = grid.length, maxCol = grid[0].length;
    boolean[][] visited = new boolean[maxRow][maxCol];
    Queue<int[]> q = new LinkedList<>();
    q.add(findStart(grid));
    int step = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int[] pos = q.poll();
        int row = pos[0], col = pos[1];
        if (grid[row][col] == '#') return step;

        for (int[] dir : DIRECTIONS) {
          int nextRow = row + dir[0], nextCol = col + dir[1];

          if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
          if (grid[nextRow][nextCol] == 'X') continue;
          if (visited[nextRow][nextCol]) continue;
          visited[nextRow][nextCol] = true;
          q.offer(new int[] {nextRow, nextCol});
        }
      }
      step++;
    }

    return -1;
  }

  private int[] findStart(char[][] grid) {
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == '*') {
          return new int[] {row, col};
        }
      }
    }
    return null;
  }
}
