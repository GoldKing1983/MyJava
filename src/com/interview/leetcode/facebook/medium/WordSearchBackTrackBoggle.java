package com.interview.leetcode.facebook.medium;

/*

https://leetcode.com/problems/word-search/description/

=============================================Requirement============================================================
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
vertically neighboring. The same letter cell may not be used more than once.

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
=============================================Solution Approach============================================================
1) For each character search recursively in all 4 directions
2) visited  avoid forming circle in search.
===========================================Understanding Backtracking======================================================
[["H","E","L","L"],
 ["L","L","A","O"]]
word : HELLOALL.

1) Lets say my direction goes down first. Consider "HE" is traversed.
2) Now recursion goes to HEL(1,1),Then 'L'(1,0). Nothing to visit.
2) Then it will backtrack to 'L' in position '0,2'. Then it will visit 'LL' in 2nd row again, through 'LL' in first row.
3) During first time visit. isVisited set to true and set to false again before going 'L' at '0,2'.
============================================================================================================================
 */
public class WordSearchBackTrackBoggle {
  // right,down,left,top
  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public boolean exist(char[][] board, String word) {
    int maxRow = board.length, maxCol = board[0].length, n = word.length();
    boolean[][] visited = new boolean[maxRow][maxCol];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] == word.charAt(0)) {
          visited[row][col] = true;
          if (backTrack(board, word, 1, n, row, maxRow, col, maxCol, visited)) return true;
          visited[row][col] = false;
        }
      }
    }
    return false;
  }

  public boolean backTrack(char[][] board, String word, int wordIndex, int n, int row, int maxRow,
      int col, int maxCol, boolean[][] visited) {
    if (wordIndex == n) return true;

    for (int[] DIRECTION : DIRECTIONS) {
      int nextRow = row + DIRECTION[0];
      int nextCol = col + DIRECTION[1];

      if (nextRow == maxRow || nextRow < 0 || nextCol == maxCol || nextCol < 0) continue;
      if (visited[nextRow][nextCol]) continue;
      if (board[nextRow][nextCol] != word.charAt(wordIndex)) continue;
      visited[nextRow][nextCol] = true;
      if (backTrack(board, word, wordIndex + 1, n, nextRow, maxRow, nextCol, maxCol, visited))
        return true;
      visited[nextRow][nextCol] = false;
    }
    return false;
  }
}
