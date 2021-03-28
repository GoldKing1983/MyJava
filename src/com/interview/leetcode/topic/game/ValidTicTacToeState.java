package com.interview.leetcode.topic.game;

/*

1) Find all the invalid case and return false.
2) Apart from invalid case, rest of all the case is true.

    1) X should be the firstPlayer always, O should be the secondPlayer.
    2) 2 player cannot win at same time
    3) If totalMoveCount other than 0 or 1 return false.
    4) If X is winner then totalMoveCount should be 1
    5) If O is winner then totalMoveCount should be 0


Ex1: input: ["XX ","O  ","   "] output: true
It is a valid case. Any player can win.

Ex2:
"XOX",
"O O",
"XOX"
Output : True

Ex3:=======Tricky Case:=======
"XOX",
"XO ",
"OXO"
Output : True
We see that no player can with above data. It is a valid case, so return true.

Ex4:
Input: board = ["XXX", "   ", "OOO"]
Output: false



 */
public class ValidTicTacToeState {
  public boolean validTicTacToe(String[] board) {
    int totalMoveCount = 0;
    int[] rows = new int[3];
    int[] cols = new int[3];
    int diagonal = 0;
    int antiDiagonal = 0;

    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (board[row].charAt(col) == 'X') {
          totalMoveCount++;
          rows[row]++;
          cols[col]++;
          if (row == col) diagonal++;
          if (row + col == 2) antiDiagonal++;
        } else if (board[row].charAt(col) == 'O') {
          totalMoveCount--;
          rows[row]--;
          cols[col]--;
          if (row == col) diagonal--;
          if (row + col == 2) antiDiagonal--;
        }
      }
    }

    boolean xWin =
        rows[0] == 3
            || rows[1] == 3
            || rows[2] == 3
            || cols[0] == 3
            || cols[1] == 3
            || cols[2] == 3
            || diagonal == 3
            || antiDiagonal == 3;
    boolean oWin =
        rows[0] == -3
            || rows[1] == -3
            || rows[2] == -3
            || cols[0] == -3
            || cols[1] == -3
            || cols[2] == -3
            || diagonal == -3
            || antiDiagonal == -3;

    if (totalMoveCount == 0 || totalMoveCount == 1) {
      if (xWin && totalMoveCount == 0) return false; // for playerX to win totalMoveCount should be 1
      if (oWin && totalMoveCount == 1) return false; // for playerO to win totalMoveCount should be 0
      if (xWin && oWin) return false; // Both players cannot be winners

      return true;
    }
    return false;
  }
}
