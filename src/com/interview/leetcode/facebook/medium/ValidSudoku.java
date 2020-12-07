package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/valid-sudoku/description/
======================================================Requirement================================================================
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

		a) a row cannot have same value again.
		b) a column cannot have the same value again.
		c) a box(3*3) cannot have the same value again.
======================================================Initial Thinking===========================================================
1) Lets take a 3*3 matrix. 3 rows and 3 colums.
2) 0th row, i can place 1,2,3.... 1st row, i can place 1,2,3.... 2nd row, i can place 1,2,3.
So total of  9 dp memory is needed for row verification.
3) Similarly 9 dp memory is needed for col verification. 
======================================================Solution Approach==========================================================
1) Create 9*9 rows, 9*9 columns and 9*9 boxes.
2) Fill the rows/cols and boxes from board.
3) If already a "number" exists in the "rows/cols and boxes" then return false.

        ====To visualize 9 boxes are========
                0 0 0 | 1 1 1 | 2 2 2
                0 0 0 | 1 1 1 | 2 2 2
                0 0 0 | 1 1 1 | 2 2 2
                --------+---------+---------
                3 3 3 | 4 4 4 | 5 5 5
                3 3 3 | 4 4 4 | 5 5 5
                3 3 3 | 4 4 4 | 5 5 5
                --------+----------+--------
                6 6 6 | 7 7 7 | 8 8 8
                6 6 6 | 7 7 7 | 8 8 8
                6 6 6 | 7 7 7 | 8 8 8

    Box Id is calculated by = (row / 3) * 3 + (col / 3);
============================================Logical Thinking - Needed Improvement================================================
If the Sudoku is filled fully. Then we are keeping
										- 9*9 space for rows
										- 9*9 space for cols
										- 9*9 space for boxes
Space Complexity could have been improved.

 */
public class ValidSudoku {
  boolean sudoku2(char[][] grid) {
    boolean[][] dpRows = new boolean[9][9];
    boolean[][] dpCols = new boolean[9][9];
    boolean[][] dpBoxes = new boolean[9][9];
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        char currentChar = grid[row][col];
        if (currentChar == '.') continue;
        int number = currentChar - '1'; // for 1 index is 0
        int boxId = (row / 3) + (col / 3) * 3;
        if (dpRows[row][number] || dpCols[col][number] || dpBoxes[boxId][number]) return false;
        dpRows[row][number] = true; // for that row, the number is filled. for 1 we save at index0.
        dpCols[col][number] = true; // for that col, the number is filled. . for 1 we save at index0.
        dpBoxes[boxId][number] = true; // for that box, the number is filled. . for 1 we save at index0.
      }
    }
    return true;
  }
}
