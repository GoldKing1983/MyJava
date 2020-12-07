package com.interview.leetcode.ebay;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/
======================================================Requirement================================================================
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
========================================================Example==================================================================
[[1,2,3],
 [4,5,6],
 [7,8,9]]

[1, 2, 3] ==> Going LeftToRight

[1, 2, 3, 6, 9] ==> Going TopToBottom

[1, 2, 3, 6, 9, 8, 7] ==> Going RightToLeft

[1, 2, 3, 6, 9, 8, 7, 4] ==> Going BottomToTop

[1, 2, 3, 6, 9, 8, 7, 4, 5] ==> Going LeftToRight
=======================================================Solution Approach=========================================================
1) Start with 0,0 with LeftToRight direction.
2) If any direction is blocked, move on to the next direction. 
3) Keep do Step2 for n times.

======================Implementation Note====================== 
1) When we turn a direction, there will be 1 or more element processable always.
So after changingDirection, we don't need to verify rowMax,colMax,rowZero,colZero validation.
2) Get the next direction by (currentDirection +1) %4 
    Ex:  currentDirection=0.          |   currentDirection=1.           |   currentDirection=3.         
         nextDirection = 0+1%4 = 1    |   nextDirection = 1+1%4 = 1     |   nextDirection = 3+1%4 = 0
=================================================================================================================================
 */
public class SpiralMatrix {
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix.length == 0) return result;
    int rowMax = matrix.length, colMax = matrix[0].length;
    int n = rowMax * colMax;
    boolean[][] visited = new boolean[rowMax][colMax];
    int currentRow = 0, currentCol = 0, currentDirection = 0;
    while (n-- > 0) {
      result.add(matrix[currentRow][currentCol]);
      visited[currentRow][currentCol] = true;
      int nextRow = currentRow + DIRECTIONS[currentDirection][0];
      int nextCol = currentCol + DIRECTIONS[currentDirection][1];

      if (nextRow == rowMax || nextRow < 0 || nextCol == colMax || nextCol < 0
          || visited[nextRow][nextCol]) { // Move on to next Direction, as current direction is blocked
        // After changingDirection, we don't need to verify rowMax,colMax,rowZero,colZero validation.
        currentDirection = (currentDirection + 1) % 4;
        currentRow += DIRECTIONS[currentDirection][0];
        currentCol += DIRECTIONS[currentDirection][1];
        continue;
      }
      currentRow = nextRow;
      currentCol = nextCol;

    }
    return result;
  }
}
