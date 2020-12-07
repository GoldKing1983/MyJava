package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/surrounded-regions/

1) Given a 2D board containing 'X' and 'O' (the letter O).
2) Capture all regions surrounded by 'X' and flip all 'O's into 'X's in that surrounded region.
3) If there is '0' in any 4 sides, then that region and all its connected '0' should be ignored.

Input:
[
["X","X","X","X"],
["X","O","O","X"],
["X","X","X","X"],
["X","O","X","X"]
]
Output:
[
["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","O","X","X"]
]

Input:
[
["X","X","X","X"],
["X","O","O","X"],
["X","X","O","O"],
["X","O","X","X"]
]

Output: Same Input will be Output. Because of 0s at sides and that connects all 0s, cannot be changed.

=========Solution Approach - Flood Fill Algorithm==================================
See Problem NumberOfClosedIslandsFloodFillAlgorithm
Step1: Change 4 sides 'O' and connected 'O' to 'Y'.
Step2: Change 'O' to 'X'.
Step3: Change 'Y' to 'O'
====================================================================

 */
public class SurroundedRegions {
  int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public void solve(char[][] board) {
    int m = board.length;
    if (m == 0) return;
    int n = board[0].length;

    // Step1: Change 4 sides 'O' and connected 'O' to 'Y'.
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if ((row == 0 || col == 0 || row == m - 1 || col == n - 1) && board[row][col] == 'O') {
          board[row][col] = 'Y';
          recur(board, row, col, m, n, 'Y');

        }
      }
    }
    // Step2: Change 'O' to 'X'.
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {

        if (board[row][col] == 'O') {
          board[row][col] = 'X';
          recur(board, row, col, m, n, 'X');
        }
      }
    }
    // Step3: Change 'Y' to 'O'
    for (int row = 0; row < m; row++) {
      for (int col = 0; col < n; col++) {
        if (board[row][col] == 'Y') board[row][col] = 'O';
      }
    }
  }

  private void recur(char[][] board, int row, int col, int maxRow, int maxCol, char updateChar) {
    for (int i = 0; i < dir.length; i++) {
      int nextRow = row + dir[i][0];
      int nextCol = col + dir[i][1];
      if (nextRow == maxRow || nextRow < 0 || nextCol == maxCol || nextCol < 0) continue;
      if (board[nextRow][nextCol] != 'O') continue;
      board[nextRow][nextCol] = updateChar;
      recur(board, nextRow, nextCol, maxRow, maxCol, updateChar);
    }
  }
}
