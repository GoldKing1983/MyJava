package com.interview.leetcode.facebook.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/walls-and-gates/

Question:
1) Fill the matrix from 0 to all INF with shortest value.
2) -1 is obstacle, 0 is source, INF is walk-through

Ex:
Input: [[0,∞,∞,∞,∞,0]]

Output: [[0,1,2,2,1,0]]

======================================Solution Approach======================================
1) Go to the "nextPoint" in 4 direction, add currentDistance+1 to the "newPoint"
2) If the "existingNextPoint" distance is less than "currentNextPoint" distance. Then ignore setting it.
No Further traversal needed for that point.
3) ===============visited logic is done by if (oldDistance < newDistance) continue;============
Once go to "nextPoint", the "nextPoint" try to come back to "previousPoint".
It was avoided, because "nextPoint" is selected from "lowToHigh".
So previous point is a "lowValue". So it is ignored similar to "visited" logic.
======================================Data Flow Analysis============================================================
Input: [[0,∞,∞,∞,∞,0]]
During First  0 Traversal Output: [[0,1,2,3,4,0]]
During Second 0 Traversal Output: [[0,1,2,2,1,0]]
====================================================================================================================

 */
public class WallsAndGatesBFS {
  private static final int GATE = 0;
  private static final int WALL = -1;
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public void wallsAndGates(int[][] rooms) {
    int rowMax = rooms.length;
    if (rowMax == 0) return;
    int colMax = rooms[0].length;

    if (rooms.length == 0) return;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (rooms[row][col] == GATE) {
          distanceToNearestGate(rooms, row, rowMax, col, colMax);
        }
      }
    }
  }

  private void distanceToNearestGate(
      int[][] rooms, int startRow, int rowMax, int startCol, int colMax) {
    Deque<int[]> q = new ArrayDeque<>();
    q.add(new int[] {startRow, startCol});
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
            || rooms[nextRow][nextCol] == WALL) {
          continue;
        }
        int newDistance = rooms[row][col] + 1;
        int oldDistance = rooms[nextRow][nextCol];

        if (oldDistance < newDistance) continue;

        rooms[nextRow][nextCol] = newDistance;
        q.add(new int[] {nextRow, nextCol});
      }
    }
  }
}
