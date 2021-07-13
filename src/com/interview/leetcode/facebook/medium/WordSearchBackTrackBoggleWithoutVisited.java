package com.interview.leetcode.facebook.medium;

/*

https://leetcode.com/problems/word-search/description/

1) same code as "WordSearchBackTrackBoggle" instead of "visited" logic, updating the board value to "#"
2) So when a point is visited it is updated to "#", to make sure not visit again.
3) During backtrack, value of grid changed to original.
==================================================
 */
public class WordSearchBackTrackBoggleWithoutVisited {
  // right,down,left,top
  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public boolean exist(char[][] board, String word) {
    int maxRow = board.length, maxCol = board[0].length, n = word.length();
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == word.charAt(0)) {
          char temp = board[row][col];
          board[row][col] = '#';
          if (backTrack(board, word, 1, n, row, maxRow, col, maxCol)) return true;
          board[row][col] = temp;
        }
      }
    }
    return false;
  }

  private boolean backTrack(char[][] board, String word, int wordIndex, int n, int row, int maxRow,
      int col, int maxCol) {
    if (wordIndex == n) return true;

    for (int[] DIRECTION : DIRECTIONS) {
      int nextRow = row + DIRECTION[0];
      int nextCol = col + DIRECTION[1];

      if (nextRow == maxRow || nextRow < 0 || nextCol == maxCol || nextCol < 0) continue;
      if (board[nextRow][nextCol] != word.charAt(wordIndex)) continue;

      char temp = board[nextRow][nextCol];
      board[nextRow][nextCol] = '#';
      if (backTrack(board, word, wordIndex + 1, n, nextRow, maxRow, nextCol, maxCol)) return true;
      board[nextRow][nextCol] = temp;
    }
    return false;
  }
}
