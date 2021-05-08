package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/*

See NearestBusStopFromAHouse

    1) For each of house. Do BFS.
    2) The queue will have currentRow,CurrentCol and distance.
    3) If bus-stop found. Update minPathDistance with currentDistance.
    4) Add visited logic to avoid creating another path. The first shortest path wins always. So we can ignore second path. 
            Ex: 
                    2   0  
                    0   0  
          In Above 1,1 can be visited only through one path through 0,1 or 1,0 based on DIRECTION logic

 */
public class NearestBusStopFromAHouseWrongApproach {
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int solve(int[][] matrix) {
    int maxRow = matrix.length, maxCol = matrix[0].length;
    int nearestDistance = Integer.MAX_VALUE;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (matrix[row][col] == 2) {
          int currentDistance = getNearestDistance(matrix, row, col);
          nearestDistance = Math.min(currentDistance, nearestDistance);
        }
      }
    }
    return nearestDistance == Integer.MAX_VALUE ? -1 : nearestDistance;
  }

  private int getNearestDistance(int[][] matrix, int startRow, int startCol) {
    int maxRow = matrix.length, maxCol = matrix[0].length;
    boolean[][] visited = new boolean[maxRow][maxCol];
    Deque<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {startRow, startCol, 0});
    visited[startRow][startCol] = true;
    while (!q.isEmpty()) {
      int[] currentPoint = q.poll();
      int currentRow = currentPoint[0];
      int currentCol = currentPoint[1];
      int currentDistance = currentPoint[2];
      for (int[] DIRECTION : DIRECTIONS) {
        int nextRow = DIRECTION[0] + currentRow;
        int nextCol = DIRECTION[1] + currentCol;
        int nextDistance = currentDistance + 1;
        if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0) continue;
        if (visited[nextRow][nextCol]) continue;
        visited[nextRow][nextCol] = true;
        // if next stop is another house or wall, then no operation
        if (matrix[nextRow][nextCol] == 1 || matrix[nextRow][nextCol] == 2) continue;
        // found bus-stop return immediate, as this is the shortest distance
        if (matrix[nextRow][nextCol] == 3) return nextDistance;
        q.offer(new int[] {nextRow, nextCol, nextDistance});
      }
    }
    return Integer.MAX_VALUE;
  }
}
