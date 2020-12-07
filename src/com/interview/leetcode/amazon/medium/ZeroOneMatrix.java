package com.interview.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/01-matrix/

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]

==================================================Solution Approach==================================================
1) Reverse the requirement, instead of finding shortest distance from non-zero to zero.
We need to find shortest distance from 0 to any "non-zero".
2) Value of "non-zero" doesn't play anything, so change all "non-zero" to Integer.MAX_VALUE.
So that it can be updated with nearest distance to zero.
3) Push all "zero" location to queue.
4) Traverse queue. Go in 4 direction.
5) If the "nextShortDistanceFromCurrent" >= previousCurrentShortDistance. No operation needed or already it has short distance.
So continue with next cell.
6) Else update the cell with "nextShortDistanceFromCurrent" and go further.

 */
public class ZeroOneMatrix {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int[][] updateMatrix(int[][] matrix) {
    int rowMax = matrix.length;
    int colMax = matrix[0].length;

    Queue<int[]> queue = new LinkedList<>();
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (matrix[row][col] == 0) {
          queue.offer(new int[] {row, col});
        } else {
          matrix[row][col] = Integer.MAX_VALUE;
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int row = cell[0];
      int col = cell[1];
      for (int[] dir : DIRECTIONS) {
        int nextRow = cell[0] + dir[0];
        int nextCol = cell[1] + dir[1];
        if (nextRow < 0 || nextRow >= rowMax || nextCol < 0 || nextCol >= colMax) continue;

        int nextShortDistanceFromCurrent = matrix[row][col] + 1;
        int previousCurrentShortDistance = matrix[nextRow][nextCol];
        if (nextShortDistanceFromCurrent >= previousCurrentShortDistance) continue;
        queue.add(new int[] {nextRow, nextCol});
        matrix[nextRow][nextCol] = nextShortDistanceFromCurrent;
      }
    }

    return matrix;
  }
}
