package com.interview.leetcode.topic.matrix;

/*
https://leetcode.com/problems/search-a-2d-matrix/
===========================================================Requirement===========================================================
1) Given an sorted input matrix from leftToRight, topToBottom, topRightCornerToNextRowBeginning.
2) Find whether elements exists or not.

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

========================================================Solution Approach========================================================
1) Elements are sorted all the way. So treat it as one long array.
2) Lets say 3 rows, 4 column in a row. So total of 12 elements and mid will be 6.
3) So we need to point 2ndRow 2ndColumn which is done by [mid / colMax][mid % colMax]
6/4 = 1, 6%4=2


 */
public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int rowMax = matrix.length;
    if (rowMax == 0) return false;
    int colMax = matrix[0].length;
    return binSearch(matrix, 0, rowMax * colMax - 1, target, colMax);
  }

  public boolean binSearch(int[][] matrix, int low, int high, int target, int colMax) {
    if (low <= high) {
      int mid = low + (high - low) / 2;
      int midValue = matrix[mid / colMax][mid % colMax];
      if (midValue == target) return true;
      else if (midValue < target) return binSearch(matrix, mid + 1, high, target, colMax);
      else return binSearch(matrix, low, mid - 1, target, colMax);
    }
    return false;
  }
}
