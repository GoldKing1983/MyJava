package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/

See Also to "ToeplitzMatrix"

Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal,
vertical, diagonal or anti-diagonal.

Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3

Input:
[[1,1,1,1]]
Output:4

Input:
[[1],
 [1],
 [1],
 [1]]
Output:4
==========================================Solution Approach========================
1) horizontal row don't need dp. Because we are traversing horizontally for each row.
2) Vertical, Diagonal and Anti-Diagonal need dp.

==========Diagonal Logic===========
1) Deciding diagonal size.

[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]

For 3*4 matrix. By manually counting. total diagonal needed is. 6. (3+4-1).i.e(m+n-1)
2) Filling diagonal DP. Looking from 0,0
		   / /
		/ /	/ /
		 / /

For 0,0 -> 0
For 0,1 -> 1
For 1,0 -> 1
For 0,2 -> 2
For 1,1 -> 2
For 2,0 -> 2
diagonalIndex = row + col;
So diagonalDP[diagonalIndex] =matrix[i][j]
==============Anti-Diagonal Logic==================================
1) Size Logic is same as diagonal.
  \
  \\\
  \\\\\

2) Filling antiDiagonal DP. Looking from bottom left 2,0
For 0,0 -> 2  --> 0-0+3-1 =2
For 0,1 -> 3  --> 0-1+3-1
For 0,2 -> 4
For 0,3 -> 5
antiDiagonalIndex = row - col + maxCol - 1;
antiDiagonalDP[antiDiagonalIndex] =matrix[i][j]
==================================================================Solution Approach==================================================================
1) For each of cell, if it is "1" increment row/col/diagonal/antiDiagonal DP.
					 else reset row/col/diagonal/antiDiagonal to 0.

 */
public class LongestLineOfConsecutiveOneInMatrixDP {
  public int longestLine(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int maxRow = matrix.length, maxCol = matrix[0].length;
    int[] verticalDP = new int[maxCol];
    int[] diagonalDP = new int[maxRow + maxCol - 1];
    int[] antiDiagonalDP = new int[maxRow + maxCol - 1];
    int max = 0;
    for (int row = 0; row < maxRow; row++) {
      int rowMax = 0;
      for (int col = 0; col < maxCol; col++) {
        int diagonalIndex = row + col;
        int antiDiagonalIndex = row - col + maxCol - 1;
        if (matrix[row][col] == 0) { // if the current cell is 0. Reset all the DPs
          rowMax = 0;
          verticalDP[col] = 0;
          diagonalDP[diagonalIndex] = 0;
          antiDiagonalDP[antiDiagonalIndex] = 0;
        } else {
          max = Math.max(max, ++rowMax);
          max = Math.max(max, ++verticalDP[col]);
          max = Math.max(max, ++diagonalDP[diagonalIndex]);
          max = Math.max(max, ++antiDiagonalDP[antiDiagonalIndex]);
        }
      }
    }
    return max;
  }
}
