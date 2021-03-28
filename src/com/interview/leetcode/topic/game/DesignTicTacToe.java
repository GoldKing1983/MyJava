package com.interview.leetcode.topic.game;

/*
https://leetcode.com/problems/design-tic-tac-toe/
========================================================Solution Approach========================================================
0) 1st is player1.. 2nd is player2
1) To win Tic-Tac-Toe you must have the entire row or column or diagonal or antiDiagonal.
Thus, we don't need to keep track of an entire n^2 board.
2) We only need to keep a count for each row, column, diagonal or antiDiagonal.
If at any time a row, column,diagonal or antiDiagonal matches the size of the board then that player has won.
3) Add +1 for Player1 and -1 for Player2.
4) At any point we see 3 or -3 winner is found.
5) Winner can be found row-wise, col-wise, diagonal or anti-diagonal.
 It (Math.abs(count) == n) then winner found. Return the current player.
=======================================================Data Flow Analysis========================================================
========================================================Ex: for 3*3 grid=========================================================
Player1 places on 0,0
		|1| | |
		| | | |
		| | | |
	rows = [1,0,0]
	cols = [1,0,0]
	diagonal = 1  => updated
	antiDiagonal = 0

Player2 places on 1,1
		|1| | |
		| |2| |
		| | | |
	rows = [1,-1,0]
	cols = [1,-1,0]
	diagonal = 0 => updated
	antiDiagonal = -1  => updated

Player1 places on 2,0
		|1| | |
		| |2| |
		|1| | |
	rows = [1,-1,1]
	cols = [2,-1,0]
	diagonal = 1
	antiDiagonal = 0 => updated

Player1 places on 1,0
		|1| | |
		|1|2| |
		|1| | |
	rows = [1,0,1]
	cols = [3,-1,0] =======> result found on col
	diagonal = 1
	antiDiagonal = 0 => updated

=================================================================================================================================
 */
public class DesignTicTacToe {
  /** Initialize your data structure here. */
  int n;
  int[] rows;
  int[] cols;
  int diagonal;
  int antiDiagonal;

  public DesignTicTacToe(int n) {
    this.n = n;
    rows = new int[n];
    cols = new int[n];
  }

  public int move(int row, int col, int player) {
    boolean isDiagonal = row + col == n - 1; //  Diagonal is /
    boolean isAntiDiagonal = row == col; // antiDiagonal is \
    if (player == 1) {
      rows[row]++;
      cols[col]++;
      if (isDiagonal) diagonal++;
      if (isAntiDiagonal) antiDiagonal++;
    } else {
      rows[row]--;
      cols[col]--;
      if (isDiagonal) diagonal--;
      if (isAntiDiagonal) antiDiagonal--;
    }
    if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n
        || Math.abs(antiDiagonal) == n) {
      return player;
    }

    return 0;

  }
}
