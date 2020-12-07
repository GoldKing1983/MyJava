package com.interview.leetcode.facebook.hard;

/*
https://leetcode.com/problems/sudoku-solver
Understand ValidSudoku first
======================================================Requirement================================================================
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
===========================================================Solution Approach=====================================================
0) Assume there are ==> 9 rows of 9 numbers... 9 cols of 9 numbers.... 9 boxes of 9 numbers
1) Create 9*9 rows, 9*9 columns and 9*9 boxes.
		9 boxes are
				[0 1 2
				 3 4 5
				 6 7 8]
	Box Id is calculated by = (row / 3) + (col / 3)  * 3;

2) For the number exist in board, update "true" in rows/cols/boxes.

3) Iterate board, for each of "."
4) For each of".", Iterate from '1' to '9' and verify anyone fits in all of rows/cols/boxes.
5) If it fits, push that number to "rows/cols/boxes"
========================================================BackTracking========================================================
1) If a number is pushed to a "rows/cols/boxes" and next phase if it fails. Then backtrack.
========================================================When To Exit========================================================
1) For ".". If '1' to '9' doesn't fits in "rows/cols/boxes", then false.

 */
public class SudokuSolver {
  private boolean[][] rows = new boolean[9][9];
  private boolean[][] cols = new boolean[9][9];
  private boolean[][] boxes = new boolean[9][9];

  public void solveSudoku(char[][] board) {
    // update true for number already exists in board
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') continue;
        int id = board[row][col] - '1';
        rows[row][id] = true;
        cols[col][id] = true;
        int box = (row / 3) + (col / 3) * 3;
        boxes[box][id] = true;
      }
    }
    solve(board, 0, 0);
  }

  private boolean solve(char[][] board, int currentRow, int currentColumn) {
    for (int row = currentRow; row < 9; row++, currentColumn = 0) {
      for (int col = currentColumn; col < 9; col++) {
        if (board[row][col] == '.') {

          for (char ch = '1'; ch <= '9'; ch++) { // fill from 1 to 9

            int id = ch - '1';
            int box = (row / 3) + (col / 3) * 3;

            if (rows[row][id] || cols[col][id] || boxes[box][id]) continue;

            board[row][col] = ch;
            rows[row][id] = true;
            cols[col][id] = true;
            boxes[box][id] = true;

            if (solve(board, row, col + 1)) return true; // For the same row move to next col

            board[row][col] = '.';
            rows[row][id] = false;
            cols[col][id] = false;
            boxes[box][id] = false;
          }
          return false;
        }
      }
    }
    return true;
  }
}
