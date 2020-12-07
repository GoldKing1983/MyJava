package com.interview.leetcode.amazon.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/sort-the-matrix-diagonally/

Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
For above data loop runs 24(2*3*4) times.


1) Sort "each diagonal numbers" m-1 times
2) Do Bubble sort for "each of column comparing with previous diagonal column" for m*n times.
3) Do Step 2 for m-1 times. So Time Complexity is (m-1)*m*n

It works because of so many sorting

Ex:
		30
			20
				10
	For above data. 2*3 times sorting will happen
1st time result would be
0th row skipped
for 1st row(from previous row 30 and 20 are compared)
		20
			30
				10
for 2nd row(from previous row 30 and 10 are compared)
		20
			10
				30

2nd time result would be
0th row skipped
for 1st row(from previous row 20 and 10 are compared)

		10
			20
				30
for 2nd row already sorted

 */
public class SortTheMatrixDiagonally {
  public int[][] diagonalSort(int[][] mat) {
    int rows = mat.length, cols = mat[0].length;
    for (int k = 0; k < rows - 1; k++) {
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (i - 1 >= 0 && j - 1 >= 0) {
            if (mat[i][j] < mat[i - 1][j - 1]) {
              int temp = mat[i - 1][j - 1];
              mat[i - 1][j - 1] = mat[i][j];
              mat[i][j] = temp;
            }
          }
        }
      }
    }
    return mat;
  }

  public static void main(String[] args) {
    SortTheMatrixDiagonally s = new SortTheMatrixDiagonally();
    int[][] input = new int[][] {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
    s.diagonalSort(input);
    System.out.println(Arrays.toString(input[0]));
    System.out.println(Arrays.toString(input[1]));
    System.out.println(Arrays.toString(input[2]));
  }
}
