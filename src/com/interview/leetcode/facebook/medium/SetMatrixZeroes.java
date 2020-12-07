package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/set-matrix-zeroes/description/
==========================================================Requirement============================================================
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Input:
  [1,1,1],
  [1,0,1],
  [1,1,1]
Output:
  [1,0,1],
  [0,0,0],
  [1,0,1]
========================================================Solution Approach========================================================
1) Use firstRow and firstColumn to track zero.
2) To track first row and first column itself, use field firstRowZero and firstColZero.
	=======Identify and Record 0 phase=======
3) Traverse entire firstRow, if there is zero update firstRowZero to true.
4) Traverse entire firstCol, if there is zero update firstColZero to true.
5) Start the traversal from 1,1 and traverse till n-1 to n-1, if there is zero update 0thRow and 0thCol.
	=======Update all field with 0 phase=======
6) Traverse column-wise from 0,1... If any cell 0, fill all columns to 0.
7) Traverse row-wise from 1,0... If any cell 0, fill entire row to 0.
8) Fill 1stRow and 1stCol based on firstRowZero=true and firstColZero=true.

 */
public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    int maxRows = matrix.length;
    int maxCols = matrix[0].length;
    // 2) To track first row and first column itself. Use a separate firstRowZero and firstColZero.
    boolean firstRowZero = false;
    boolean firstColZero = false;
    // =======Identify and Record 0 phase=======
    if (matrix[0][0] == 0) {
      firstRowZero = true;
      firstColZero = true;
    } else {
      // 3) Traverse entire firstRow, if there is zero update firstRowZero to true.
      for (int col = 1; col < maxCols; col++) {
        if (matrix[0][col] == 0) {
          firstRowZero = true;
          break;
        }
      }
      // 4) Traverse entire firstCol, if there is zero update firstColZero to true.
      for (int row = 1; row < maxRows; row++) {
        if (matrix[row][0] == 0) {
          firstColZero = true;
          break;
        }
      }
    }
    // 5) Traverse from 1,1 till n-1,n-1, if there is zero update 0thRow and 0thCol.
    for (int row = 1; row < maxRows; row++) {
      for (int col = 1; col < maxCols; col++) {
        if (matrix[row][col] == 0) {
          matrix[0][col] = 0;
          matrix[row][0] = 0;
        }
      }
    }
    // =======Update all field with 0 phase=======
    // 6) Traverse column-wise from 0,1... If any cell 0, fill entire columns to 0.
    for (int col = 1; col < maxCols; col++) {
      if (matrix[0][col] != 0) continue;
      for (int row = 1; row < maxRows; row++) matrix[row][col] = 0;
    }
    // 7) Traverse row-wise from 1,0... If any cell 0, fill entire row to 0.
    for (int row = 1; row < maxRows; row++) {
      if (matrix[row][0] != 0) continue;
      for (int col = 1; col < maxCols; col++) matrix[row][col] = 0;
    }
    // 8) Fill 1stRow and 1stCol based on firstRowZero=true and firstColZero=true.
    if (firstRowZero) for (int col = 0; col < maxCols; col++) matrix[0][col] = 0;
    if (firstColZero) for (int row = 0; row < maxRows; row++) matrix[row][0] = 0;
  }
}
