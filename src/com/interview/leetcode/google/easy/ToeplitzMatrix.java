package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/toeplitz-matrix/description/

See Also to "LongestLineOfConsecutiveOneInMatrixDP"

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation: In the above grid, the diagonals are: "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

=================================================Solution Approach - Brilliant===================================================
1) Initial thinking would come from bottom left and move upward. But that is un-necessary and complicates the coding.
2) Right thinking is, for each number, verify diagonal number. If currentNumber != diagonalNumber return false.
 */
public class ToeplitzMatrix {

  public boolean isToeplitzMatrix(int[][] matrix) {
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (row + 1 == maxRow || col + 1 == maxCol) continue;
        int currentNumber = matrix[row][col];
        int diagonalNumber = matrix[row + 1][col + 1];
        if (currentNumber != diagonalNumber) {
          return false;
        }
      }
    }
    return true;
  }
}
