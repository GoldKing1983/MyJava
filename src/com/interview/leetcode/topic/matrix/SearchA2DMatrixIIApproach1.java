package com.interview.leetcode.topic.matrix;

/*
https://leetcode.com/problems/search-a-2d-matrix/
See Also CountNegativeNumbersInASortedMatrix

1) Given an sorted input matrix from leftToRight(row-wise), topToBottom(col-wise) but not topRightCornerToNextRowBeginning.
2) Find whether elements exists or not.

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
========================================================Solution Common Point====================================================
1) Remember the reverse-z
2) So 2 solution possible. topRightCorner to bottomLeftCorner or bottomLeftCorner to topRightCorner
                     -------
                    |
                    |
                    |
             -------
==========================================================Note===================================================================
1) We are not doing any binary search. It is a simple move about any direction
2) See https://leetcode.com/problems/search-a-2d-matrix-ii/solution/ Approach4 PNG video.
====================================================Solution Approach============================================================
1) Start search from bottom left corner.
2) If currentValueInMatrix > target decrement row or move up. Ex:18>10
3) Else increment col.
====================================================Time Complexity: O(m+n)======================================================
 */
public class SearchA2DMatrixIIApproach1 {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) return false;
    int rowMax = matrix.length;
    return searchFromBottomLeftCorner(rowMax - 1, 0, matrix, target);
  }

  private boolean searchFromBottomLeftCorner(int row, int col, int[][] matrix, int target) {
    // Row moves from Bottom to Top. Col moves from Left to Right.
    if (row < 0 || col == matrix[0].length) return false;

    int currentValue = matrix[row][col];

    if (currentValue == target) return true;
    if (currentValue > target) return searchFromBottomLeftCorner(row - 1, col, matrix, target);
    return searchFromBottomLeftCorner(row, col + 1, matrix, target);
  }
}
