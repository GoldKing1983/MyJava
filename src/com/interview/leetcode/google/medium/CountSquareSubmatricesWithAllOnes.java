package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/count-square-submatrices-with-all-ones/

Similar to https://leetcode.com/problems/maximal-square/

1) If A[i][j] == 0, no possible square.
2) Viewing from bottom right corner. if current is 1 and  left, Up and diagonal is more than 0 increment by 1 is the
step1 thinking solution.
3) But to carry forward 4 side square to next square and to bigger square. it should "min of 3 sides+1"

[[1,1,1],
 [1,1,1],
 [1,1,1]]
Answer = 14

Updated matrix:
[1, 1, 1]
[1, 2, 2]
[1, 2, 3]


 */
public class CountSquareSubmatricesWithAllOnes {
  public int countSquares(int[][] matrix) {
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;
    for (int i = 1; i < maxRow; i++) {
      for (int j = 1; j < maxCol; j++) {
        // Ex: [[1,1],[0,0]]. Only if cell is 1 then add+1 of min.
        if (matrix[i][j] == 1) {
          int left = matrix[i][j - 1];
          int top = matrix[i - 1][j];
          int diagonal = matrix[i - 1][j - 1];
          matrix[i][j] = Math.min(Math.min(left, top), diagonal) + 1;
        }
      }
    }
    int squareCount = 0;
    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        squareCount += matrix[i][j];
      }
    }
    return squareCount;
  }
}
