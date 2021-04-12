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
2) 1st row, i can place 1,2,3.... 2nd row, i can place 1,2,3.... 3rd row, i can place 1,2,3.
So total of  9 dp memory is needed for row verification.
3) Similarly 9 dp memory is needed for col verification. 
======================================================Solution Approach==========================================================

1) Create 9*9 rows, 9*9 columns and 9*9 boxes.
   Note we create 10*10 and 0thRow and 0thCol is ignored as the number is from 1 to 9.
2) Fill the rows/cols and boxes from board.
3) If already a "number" exists in the "rows/cols and boxes" then return false.
========================================================Logic For Boxes==========================================================
        ====we expect 9 boxes to be like below========
                 1 1 1 | 2 2 2 | 3 3 3
                 1 1 1 | 2 2 2 | 3 3 3
                 1 1 1 | 2 2 2 | 3 3 3
               --------+-------+-----------
                 4 4 4 | 5 5 5 | 6 6 6
                 4 4 4 | 5 5 5 | 6 6 6
                 4 4 4 | 5 5 5 | 6 6 6
               --------+-------+-----------
                 7 7 7 | 8 8 8 | 9 9 9 
                 7 7 7 | 8 8 8 | 9 9 9
                 7 7 7 | 8 8 8 | 9 9 9
        ====but 9 boxes are saved like below========
                 0 0 0 | 1 1 1 | 2 2 2
                 0 0 0 | 1 1 1 | 2 2 2
                 0 0 0 | 1 1 1 | 2 2 2
               --------+-------+-----------
                 3 3 3 | 4 4 4 | 5 5 5
                 3 3 3 | 4 4 4 | 5 5 5
                 3 3 3 | 4 4 4 | 5 5 5
               --------+-------+-----------
                 6 6 6 | 7 7 7 | 8 8 8
                 6 6 6 | 7 7 7 | 8 8 8
                 6 6 6 | 7 7 7 | 8 8 8

    Box Id is calculated by = (row / 3) * 3 + (col / 3);
                ex: 
                    0,0 and 0,1 and 0,2
                    1,0 and 1,1 and 1,2
                    2,0 and 2,1 and 2,2
                    
                    all above 9 calculation leads to 0.
============================================Logical Thinking - Needed Improvement================================================
If the Sudoku is filled fully. Then we are keeping
										- 9*9 space for rows
										- 9*9 space for cols
										- 9*9 space for boxes
Space Complexity could have been improved.

 */
public class ValidSudoku {


  private boolean[][] dpCols = new boolean[9][9];
  private boolean[][] dpRows = new boolean[9][9];
  private boolean[][] dpBoxes = new boolean[9][9];

  public boolean isValidSudoku(char[][] board) {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') continue;

        int numIndex = board[row][col] - '1'; // for 1 index is 0
        int boxIndex = (row / 3) * 3 + (col / 3);
        if (dpRows[row][numIndex] || dpCols[col][numIndex] || dpBoxes[boxIndex][numIndex])
          return false;

        dpRows[row][numIndex] = true; // for that row, the number is filled. for 1 we save at index0.
        dpCols[col][numIndex] = true;// for that col, the number is filled. . for 1 we save at index0.
        dpBoxes[boxIndex][numIndex] = true;// for that box, the number is filled. . for 1 we save at index0.
      }
    }
    return true;
  }

}
