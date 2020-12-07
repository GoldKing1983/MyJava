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
          ===isVisited does 2 tricks====
2) To avoid forming circle in search.
3) BackTracking - IsVisited will be set to true for path1 and set to false for path2.
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
  private int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public boolean exist(char[][] board, String word) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        if (word.charAt(0) == board[row][col]) {
          if (recur(board, row, col, word, 0, isVisited)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean recur(
      char[][] board, int row, int col, String word, int index, boolean[][] isVisited) {
    if (index == word.length()) return true;

    if (row == board.length || row < 0 || col == board[0].length || col < 0) return false;
    if (isVisited[row][col] || board[row][col] != word.charAt(index)) return false;

    isVisited[row][col] = true;

    for (int i = 0; i < dir.length; i++)
      if (recur(board, dir[i][0] + row, dir[i][1] + col, word, index + 1, isVisited)) return true;

    isVisited[row][col] = false;

    return false;
  }
}
