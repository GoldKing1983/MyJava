package com.interview.leetcode.topic.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
===========================================================Requirement===========================================================
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
=========================================================Initial Thought=========================================================
1) Do DFS or BFS and fill the matrix distance from 1 to 0.
2) But DFS goes depth-wise which doesn't save the shortest path.
3) BFS goes like level and captures shortest path for each of 1to0.
=======================================================Data Flow Analysis========================================================
input                 : [1, 0, 0, 0, 1]

====after bfs for 1 at 0,0====
distanceFrom1to0      :[0, 1, 2, 3, 0]
accessToBuildingCount :[0, 1, 1, 1, 0]
====after bfs for 1 at 0,4====
currentDistanceFrom1to0 at location 0,3  :[0, 3, 2, 1, 0]
previousDistanceFrom1to0 at location 0,3 :[0, 1, 2, 3, 0]

summing currentDistanceFrom1to0 and previousDistanceFrom1to0 will give distanceFrom1to0.

Above calculation is given only for understanding, but code directly sums the distanceFrom1to0

distanceFrom1to0      : [0, 4, 4, 4, 0]
accessToBuildingCount : [0, 2, 2, 2, 0]

Now find totalBuildingCount with 2 with minimum distance.
Ans = 4
=======================================================Data Flow Analysis========================================================
input                 : [1, 0, 2, 0, 1]

====after bfs for 1 at 0,0====
distanceFrom1to0      : [0, 1, 0, 0, 0]
accessToBuildingCount :[0, 1, 0, 0, 0]
====after bfs for 1 at 0,4====
distanceFrom1to0      : [0, 1, 0, 1, 0]
accessToBuildingCount :[0, 1, 0, 1, 0]

Now find totalBuildingCount with 2 with minimum distance.
none of accessToBuildingCount not matches 2. So answer -1
 */
public class ShortestDistanceFromAllBuildings {
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
        doBFS(grid, row, col, maxRow, maxCol);
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

  private void doBFS(int grid[][], int startRow, int startCol, int maxRow, int maxCol) {
    int distanceCount = 1;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] isVisited = new boolean[maxRow][maxCol];
    q.offer(new int[] {startRow, startCol});

    while (!q.isEmpty()) {
      int qSize = q.size();
      while (qSize-- > 0) {
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
  }
}
