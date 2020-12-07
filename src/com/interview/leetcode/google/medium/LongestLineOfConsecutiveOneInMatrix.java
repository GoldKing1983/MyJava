package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/

Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal,
vertical, diagonal or anti-diagonal.

Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3

==========================================Solution Approach========================
1) Traverse horizontally count max.
2) Traverse vertically count max.
3) Traverse diagonally count max.
4) Traverse vertically count max.

 */
public class LongestLineOfConsecutiveOneInMatrix {
  public int longestLine(int[][] matrix) {
    int maxRow = matrix.length;
    if (maxRow == 0) return 0;
    int maxCol = matrix[0].length;
    int max = 0;

    for (int i = 0; i < maxRow; i++) {
      int currentMax = 0;
      for (int j = 0; j < maxCol; j++) {
        if (matrix[i][j] == 1) {
          currentMax++;
          max = Math.max(max, currentMax);
        } else {
          currentMax = 0;
        }
      }
    }
    for (int i = 0; i < maxCol; i++) {
      int currentMax = 0;
      for (int j = 0; j < maxRow; j++) {
        if (matrix[j][i] == 1) {
          currentMax++;
          max = Math.max(max, currentMax);
        } else {
          currentMax = 0;
        }
      }
    }
    // Diagonal possible only when maxCol > 1 && maxRow > 1
    if (maxCol > 1 && maxRow > 1) {

      // Diagonal from bottom left to up
      int row = maxRow - 1;
      int outerRow = row;
      int col = 0;
      int outerCol = col;
      int currentMax = 0;

      while (true) {
        if (matrix[row][col] == 1) {
          currentMax++;
          max = Math.max(max, currentMax);
        } else {
          currentMax = 0;
        }
        row++;
        col++;
        if (row == 1 && col == maxCol) break;
        if (row == maxRow || col == maxCol) {
          outerRow--;
          if (outerRow < 0) {
            row = 0;
            outerCol++;
            col = outerCol;
            currentMax = 0;
          } else {
            row = outerRow;
            col = 0;
            currentMax = 0;
          }
        }
      }
      // Anti-Diagonal from bottom right to up
      row = maxRow - 1;
      col = maxCol - 1;
      outerCol = col;
      outerRow = row;

      while (true) {
        if (matrix[row][col] == 1) {
          currentMax++;
          max = Math.max(max, currentMax);
        } else {
          currentMax = 0;
        }
        row++;
        col--;

        if (row == 1 && col == -1) break;
        if (row == maxRow || col == -1) {
          outerRow--;
          if (outerRow < 0) {
            row = 0;
            outerCol--;
            col = outerCol;
            currentMax = 0;
          } else {
            row = outerRow;
            col = maxCol - 1;
            currentMax = 0;
          }
        }
      }
    }

    return max;
  }
}
