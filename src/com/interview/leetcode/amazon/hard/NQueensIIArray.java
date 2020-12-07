package com.interview.leetcode.amazon.hard;

/*
https://leetcode.com/problems/n-queens-ii/
https://www.youtube.com/watch?v=xouin83ebxE

1) dpColumns size is n+1 because 0thIndex is not used.
2) dpDiagonals and dpAntiDiagonals size 2n. 
================================================================================================================================
 */
public class NQueensIIArray {

  public int totalNQueens(int n) {
    // We don't need dpRows. Because we traverse row by row. After 0th row, we will place queen in 1st row. So memoize not needed.
    boolean[] dpColumns = new boolean[n + 1]; // -------------columns |
    boolean[] dpDiagonals = new boolean[n + n]; // -----diagonals /
    boolean[] dpAntiDiagonals = new boolean[n + n]; // ----anti-diagonals \

    totalNQueensHelper(0, n, dpColumns, dpDiagonals, dpAntiDiagonals);
    return count;
  }

  int count = 0;

  private void totalNQueensHelper(int row, int n, boolean[] dpColumns, boolean[] dpDiagonals,
      boolean[] dpAntiDiagonals) {
    if (row == n) {
      count++; // row reached "n". We found a combination.
      return;
    }
    for (int col = 0; col < n; col++) {
      if (dpColumns[col]) continue;

      int diagonal = row + col;
      if (dpDiagonals[diagonal]) continue;

      int antiDiagonal = row - col + n;
      if (dpAntiDiagonals[antiDiagonal]) continue;

      dpColumns[col] = true;
      dpAntiDiagonals[antiDiagonal] = true;
      dpDiagonals[diagonal] = true;

      totalNQueensHelper(row + 1, n, dpColumns, dpDiagonals, dpAntiDiagonals);

      dpColumns[col] = false;
      dpAntiDiagonals[antiDiagonal] = false;
      dpDiagonals[diagonal] = false;
    }
  }
}
