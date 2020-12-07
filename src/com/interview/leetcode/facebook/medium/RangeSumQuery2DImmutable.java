package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/range-sum-query-2d-immutable
https://www.youtube.com/watch?v=PwDqpOMwg6U
============input=======
[1,2,3],
[4,5,6],
[7,8,9]
===========dp array final ========
[1, 3, 6]
[5, 12, 21]
[12, 27, 45]
		=============Fill First row sum=============
[1, 3, 0]
[0, 0, 0]
[0, 0, 0]

[1, 3, 6]
[0, 0, 0]
[0, 0, 0]
		=============Fill First col sum=============
[1, 3, 6]
[5, 0, 0]
[0, 0, 0]

[1, 3, 6]
[5, 0, 0]
[12, 0, 0]
		=============Fill the rest=============
===========Step By Step How dp Array is formed===========
	x from source matrix.
	a, b, c from dp matrix.

    a || b
    =======
    c || x

    x = c + b - a + x;

[1, 3, 6]
[5, 12, 0]
[12, 0, 0]

[1, 3, 6]
[5, 12, 21]
[12, 0, 0]

[1, 3, 6]
[5, 12, 21]
[12, 27, 0]  --->8

[1,  3,  6]
[5, 12, 21]
[12, 27, 45]  --->9

================ Pick value for sum region =======
input =
[1,2,3],
[4,5,6],
[7,8,9]

 dp =
[1,  3,  6]
[5, 12, 21]
[12, 27, 45]

For Input : 1,1 to 2,1

dp[2,1] = 27
dp[0,1] = 3  -
dp[2,0] = 12 -
dp[0,0] = 1  +
         ====
          13
         ====
  	To find region between A and B.
	[x, y, 0]
	[0, A, 0]
	[z, B, 0]

	Answer = B-y-z+x

Addition is needed because "x" is there both row-wise and column-wise

 */
public class RangeSumQuery2DImmutable {
  private int[][] preSums;

  public RangeSumQuery2DImmutable(int[][] matrix) {
    int maxRow = matrix.length;
    if (maxRow == 0) return;
    int maxCol = matrix[0].length;
    preSums = new int[maxRow][maxCol];
    buildPresums(matrix, maxRow, maxCol);
  }

  private void buildPresums(int[][] matrix, int maxRow, int maxCol) {
    preSums[0][0] = matrix[0][0];
    // fill first row with sum from left side
    for (int row = 1; row < maxRow; row++) preSums[row][0] = matrix[row][0] + preSums[row - 1][0];
    // fill first row with sum from top
    for (int col = 1; col < maxCol; col++) preSums[0][col] = matrix[0][col] + preSums[0][col - 1];

    for (int row = 1; row < maxRow; row++) {
      for (int col = 1; col < maxCol; col++) {
        int leftPresum = preSums[row][col - 1];
        int topPresum = preSums[row - 1][col];
        int diagonalPreSum = preSums[row - 1][col - 1];
        int source = matrix[row][col];
        int currentPresum = source + leftPresum + topPresum - diagonalPreSum;
        preSums[row][col] = currentPresum;
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int topMaxRectPresum = row1 == 0 ? 0 : preSums[row1 - 1][col2];
    int leftMaxRectPresum = col1 == 0 ? 0 : preSums[row2][col1 - 1];
    int diagonalMaxRectPresum = (row1 == 0 || col1 == 0) ? 0 : preSums[row1 - 1][col1 - 1];
    int currentPresum = preSums[row2][col2];

    return currentPresum - leftMaxRectPresum - topMaxRectPresum + diagonalMaxRectPresum;
  }
}
