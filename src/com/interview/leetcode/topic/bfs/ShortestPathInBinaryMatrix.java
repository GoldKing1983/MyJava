package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
https://leetcode.com/problems/shortest-path-in-binary-matrix/


*/
public class ShortestPathInBinaryMatrix {
  private int DIRECTIONS[][] =
      new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

  public int shortestPathBinaryMatrix(int[][] grid) {

    int maxRow = grid.length;
    int maxCol = grid[0].length;

    if (grid[0][0] == 1 || grid[maxRow - 1][maxCol - 1] == 1) return -1;

    boolean[][] visited = new boolean[maxRow][maxCol];
    visited[0][0] = true;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {0, 0});
    int shortestPathCount = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int[] currPos = queue.remove();
        int currRow = currPos[0], currCol = currPos[1];
        if (currRow == maxRow - 1 && currCol == maxCol - 1) return shortestPathCount;

        for (int i = 0; i < 8; i++) {
          int nextRow = DIRECTIONS[i][0] + currRow;
          int nextCol = DIRECTIONS[i][1] + currCol;

          if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
          if (visited[nextRow][nextCol]) continue;
          if (grid[nextRow][nextCol] != 0) continue;

          queue.add(new int[] {nextRow, nextCol});
          visited[nextRow][nextCol] = true;
        }
      }
      shortestPathCount++;
    }

    return -1;
  }
}
