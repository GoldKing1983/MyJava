package com.interview.leetcode.facebook.medium;

/*

https://leetcode.com/problems/word-search/description/

1) same code as "WordSearchBackTrackBoggle" instead of "isVisited" logic, updating the board value to "#"
2) So when a point is visited it is updated to "#", to make sure not visit again.
3) During backtrack, value of grid changed to original.
==================================================
 */
public class WordSearchBackTrackBoggleWithoutVisited {
  // right,down,left,top
  private int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public boolean exist(char[][] board, String word) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (recur(board, row, col, word, 0)) return true;
      }
    }
    return false;
  }

  private boolean recur(char[][] board, int row, int col, String word, int index) {
    if (index == word.length()) return true;

    if (row == board.length || row < 0 || col == board[0].length || col < 0) return false;
    if (board[row][col] == '#' || board[row][col] != word.charAt(index)) return false;

    char temp = board[row][col];
    board[row][col] = '#';

    for (int i = 0; i < dir.length; i++)
      if (recur(board, dir[i][0] + row, dir[i][1] + col, word, index + 1)) return true;

    board[row][col] = temp;

    return false;
  }
}
