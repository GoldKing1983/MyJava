package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
 *

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes output matrix:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
====================

The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

1  2  3
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3
 */
public class RotateImage {
  int[][] rotateImage(int[][] a) {
    int rowMax = a.length;
    int colMax = a[0].length;
    for (int row = 0; row < rowMax; row++) {
      for (int col = row + 1; col < colMax; col++) { // 0,1 with 1,0
        int temp = a[row][col];
        a[row][col] = a[col][row];
        a[col][row] = temp;
      }
    }
    // for each row swap left and right
    for (int row = 0; row < rowMax; row++) {
      for (int left = 0, right = colMax - 1; left < right; left++, right--) {
        int temp = a[row][right];
        a[row][right] = a[row][left];
        a[row][left] = temp;
      }
    }
    return a;
  }
}
