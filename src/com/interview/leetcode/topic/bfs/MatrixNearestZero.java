package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://binarysearch.com/problems/Matrix-Nearest-Zero

1) Given a input matrix.
2) Update 1 with closest 0s.  

Input  : [0, 1, 1, 1]
Output : [0, 1, 2, 3]

Input  : [1, 1, 1, 0]
Output : [3, 2, 1, 0]

Input  : [0, 1, 1, 0]
Output : [0, 1, 1, 0]


Input
    [1, 1, 1],
    [1, 0, 1],
    [0, 0, 0]
Output
    [2, 1, 2],
    [1, 0, 1],
    [0, 0, 0]


KeyPoints:
1) I don't need to do bfs multiple times for each0.
2) Similar to problem "NearestBusStopFromAHouse", I can push all the source to queue and I can do bfs once. 
 */
public class MatrixNearestZero {
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int[][] solve(int[][] matrix) {
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;
    int[][] dp = new int[maxRow][maxCol];
    boolean[][] visited = new boolean[maxRow][maxCol];
    Deque<int[]> q = new ArrayDeque<>();

    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (matrix[row][col] == 0) {
          q.offer(new int[] {row, col, 0});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] currPoint = q.poll();
      int currRow = currPoint[0];
      int currCol = currPoint[1];
      int nextDistance = currPoint[2] + 1;

      for (int[] DIRECTION : DIRECTIONS) {
        int nextRow = currRow + DIRECTION[0];
        int nextCol = currCol + DIRECTION[1];
        if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0) continue;
        if (visited[nextRow][nextCol]) continue;
        visited[nextRow][nextCol] = true;
        if (matrix[nextRow][nextCol] == 0) continue;
        dp[nextRow][nextCol] = nextDistance;
        q.offer(new int[] {nextRow, nextCol, nextDistance});
      }
    }

    return dp;

  }
}
