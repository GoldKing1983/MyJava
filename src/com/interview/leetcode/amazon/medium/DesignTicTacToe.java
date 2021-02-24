package com.interview.leetcode.amazon.medium;

/*

1) To win Tic-Tac-Toe you must have the entire row or column or diagonal or antiDiagonal.
Thus, we don't need to keep track of an entire n^2 board.
2) We only need to keep a count for each row, column, diagonal or antiDiagonal.
If at any time a row, column,diagonal or antiDiagonal matches the size of the board then that player has won.
3) Add +1 for Player1 and -1 for Player2.
4) Each time player places a piece we just need to update the count and check the count of
row, column, diagonal and anti-diagonal. It (Math.abs(count) == n) then winner found. 

Tricky Point is how rows and cols are tracked. Because for 3*3 grid, 
		1) There are 3 ways row-wise win can happen.
		2) There are 3 ways col-wise win can happen.
		3) Diagonally 1 way win can happen.
		4) AntiDiagonally 1 way win can happen.
===========================================================Ex: for 3*3 grid======================================================
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
