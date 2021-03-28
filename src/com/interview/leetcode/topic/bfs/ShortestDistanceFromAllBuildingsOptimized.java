package com.interview.leetcode.topic.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/shortest-distance-from-all-buildings/

1) Same code as ShortestDistanceFromAllBuildings. But the difference is
2) Only change is... At any point, if any building is not accessible return immediately.

Ex:
[1 0 2 0 1 0 1]

when we do BFS at location 0,0 we can return immediately.
so BFS at location 0,3 and 0,5 is not required.

===how are we achieving===
if any point is 1 and it is not visited then return false.


 */
public class ShortestDistanceFromAllBuildingsOptimized {
  private int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  int[][] distanceFrom1to0, accessToBuildingCount;

  public int shortestDistance(int[][] grid) {

    int maxRow = grid.length, maxCol = grid[0].length;
    distanceFrom1to0 = new int[maxRow][maxCol];
    accessToBuildingCount = new int[maxRow][maxCol];
    int totalBuildingCount = 0;

    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (grid[row][col] != 1) continue;
        totalBuildingCount++;
        if (!doBFS(grid, row, col, maxRow, maxCol)) return -1;
      }
    }

    // Now that the distance and accessibility are updated, go through the grid
    // and find the shortest distance on an empty plot that also reaches all buildings
    int minDistance = Integer.MAX_VALUE;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (grid[row][col] != 0 || accessToBuildingCount[row][col] != totalBuildingCount) continue;
        minDistance = Math.min(minDistance, distanceFrom1to0[row][col]);
      }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

  private boolean doBFS(int grid[][], int startRow, int startCol, int maxRow, int maxCol) {
    int distanceCount = 1;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[maxRow][maxCol];
    q.offer(new int[] {startRow, startCol});

    while (!q.isEmpty()) {
      int qSize = q.size();
      while(qSize-- > 0){
        int[] currentPos = q.poll();
        int currentRow = currentPos[0];
        int currentCol = currentPos[1];

        for (int i = 0; i < 4; i++) {
          int nextRow = DIRECTIONS[i][0] + currentRow;
          int nextCol = DIRECTIONS[i][1] + currentCol;
          if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0) continue;
          if (isVisited[nextRow][nextCol]) continue;
          isVisited[nextRow][nextCol] = true;

          if (grid[nextRow][nextCol] != 0) continue;

          distanceFrom1to0[nextRow][nextCol] += distanceCount;
          accessToBuildingCount[nextRow][nextCol]++;

          q.offer(new int[] {nextRow, nextCol});
        }
      }
      distanceCount++;
    }

    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (!isVisited[row][col] && grid[row][col] == 1) {
          return false;
        }
      }
    }
    return true;
  }
}
