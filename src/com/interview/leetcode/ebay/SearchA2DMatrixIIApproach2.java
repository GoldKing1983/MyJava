package com.interview.leetcode.ebay;

/*
https://leetcode.com/problems/search-a-2d-matrix/

Requirement:
1) Integers in each row are sorted in ascending from left to right.
2) Integers in each column are sorted in ascending from top to bottom.
3) Find whether given target exists in matrix efficiently.

Input:
matrix = [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
target = 3
Output: true

==========================================================Note===================================================================
1) We are not doing any binary search. It is a simple move about any direction
2) See https://leetcode.com/problems/search-a-2d-matrix-ii/solution/ Approach4 PNG video.
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
