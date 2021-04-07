package com.interview.leetcode.topic.matrix;

/*
Similar to SearchA2DMatrixIIApproach1. But we start the search from top right corner.
====================================================Solution Approach============================================================
1) Start search from top right corner.
2) If currentValueInMatrix > target decrement col or move left. Ex:15>10
3) Else increment row.

 */
public class SearchA2DMatrixIIApproach2 {

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix==null || matrix.length==0) return false;
    int colMax = matrix[0].length;
    return searchFromTopRightCorner(0, colMax - 1, matrix, target);
  }

  private boolean searchFromTopRightCorner(int row, int col, int[][] matrix, int target) {
    if (row == matrix.length || col < 0) return false;
    int currentValue = matrix[row][col];
    if (currentValue == target) return true;
    if (currentValue > target) return searchFromTopRightCorner(row, col - 1, matrix, target);
    return searchFromTopRightCorner(row + 1, col, matrix, target);
  }


}
