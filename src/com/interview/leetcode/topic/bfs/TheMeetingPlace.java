package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://binarysearch.com/problems/The-Meeting-Place
Almost Same problem as ShortestDistanceFromAllBuildings, with 1 less constraint.. there will be a path always.
So accessToBuildingCount is not needed.
 */
public class TheMeetingPlace {

  public int solve(int[][] matrix) {
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;
    int[][] dp = new int[maxRow][maxCol];

    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        if (matrix[row][col] == 2) {
          visited.computeIfAbsent(row, v -> new HashSet<>()).add(col);
          bfs(matrix, dp, row, col, maxRow, maxCol, visited);
        }

      }
    }
    int minimumDistance = Integer.MAX_VALUE;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (matrix[row][col] == 1 || dp[row][col] == 0) continue;
        minimumDistance = Math.min(minimumDistance, dp[row][col]);
      }
    }
    return minimumDistance == Integer.MAX_VALUE ? 0 : minimumDistance;

  }

  private int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private void bfs(int[][] matrix, int[][] dp, int startRow, int startCol, int maxRow, int maxCol,
      Map<Integer, Set<Integer>> visited) {
    Deque<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {startRow, startCol, 0});
    while (!q.isEmpty()) {
      int[] currentPoint = q.poll();
      int currentRow = currentPoint[0];
      int currentCol = currentPoint[1];
      int currentDistance = currentPoint[2];
      for (int i = 0; i < 4; i++) {
        int nextRow = DIRECTIONS[i][0] + currentRow;
        int nextCol = DIRECTIONS[i][1] + currentCol;
        int nextDistance = currentDistance + 1;
        if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0) continue;
        if ((visited.containsKey(nextRow) && visited.get(nextRow).contains(nextCol))) continue;
        visited.computeIfAbsent(nextRow, v -> new HashSet<>()).add(nextCol);
        if (matrix[nextRow][nextCol] == 1) continue;
        dp[nextRow][nextCol] = dp[nextRow][nextCol] + nextDistance;
        q.offer(new int[] {nextRow, nextCol, nextDistance});

      }
    }
  }
}
