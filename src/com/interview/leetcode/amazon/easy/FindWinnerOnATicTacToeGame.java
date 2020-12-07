package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

Understand DesignTicTacToe. This problem is almost same with board size=3
 */
public class FindWinnerOnATicTacToeGame {
  public String tictactoe(int[][] moves) {
    // A = +1, B= -1
    int[] rows = new int[3];
    int[] cols = new int[3];
    int diagonal = 0;
    int antiDiagonal = 0;

    boolean playerA = true;
    int moveCount = 0;
    for (int[] move : moves) {
      int row = move[0];
      int col = move[1];
      if (playerA) {
        playerA = false;
        rows[row]++;
        cols[col]++;
        if (row == col) diagonal++;
        if (row + col == 2) antiDiagonal++;
        if (rows[row] == 3 || cols[col] == 3 || diagonal == 3 || antiDiagonal == 3) return "A";
      } else {
        playerA = true;
        rows[row]--;
        cols[col]--;
        if (row == col) diagonal--;
        if (row + col == 2) antiDiagonal--;
        if (rows[row] == -3 || cols[col] == -3 || diagonal == -3 || antiDiagonal == -3) return "B";
      }
      moveCount++;
    }
    return moveCount == 9 ? "Draw" : "Pending";
  }
}
