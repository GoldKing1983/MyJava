package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/walls-and-gates/

Question:
1) Fill the matrix from 0 to all INF with shortest value.
2) -1 is obstacle, 0 is source, INF is walk-through

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
public class WallsAndGatesDFS {

  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  private static final int WALL = -1;

  public void wallsAndGates(int[][] rooms) {
    int rowMax = rooms.length;
    int colMax = rowMax > 0 ? rooms[0].length : 0;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (rooms[row][col] == 0) expand(rooms, row, rowMax, col, colMax, 0);
      }
    }
  }

  public void expand(int[][] rooms, int row, int rowMax, int col, int colMax, int dist) {
    if (row < 0
        || row == rowMax
        || col < 0
        || col == colMax
        || rooms[row][col] == WALL
        || rooms[row][col] < dist) {
      return;
    }

    rooms[row][col] = dist;
    for (int i = 0; i < 4; i++)
      expand(rooms, row + dirs[i][0], rowMax, col + dirs[i][1], colMax, dist + 1);
  }
}
