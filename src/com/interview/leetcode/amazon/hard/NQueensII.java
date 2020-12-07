package com.interview.leetcode.amazon.hard;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/n-queens-ii/
https://www.youtube.com/watch?v=xouin83ebxE
========================================Requirement==============================================================================
A valid move is possible, if no queen present horizontally, vertically and diagonally
 				   \   |   /
 					 \ | /
 				  ==== Q ====
 					 / | \
                   /   |   \
========================================Approach1================================================================================
Keep the first queen in (0,0). Try placing next queen in next-row column-wise.
Ex: Next 1,0 ==> 1,1 ==> 1,2 ==> 1,3... Row stays, column increments
========================================Approach2================================================================================
Keep the first queen in (0,0). Try placing next queen in row-wise.
Ex: Next 1,0 ==> 2,0 ==> 3,0 ==> 4,0... Column stays, row increments

========================================Solution Based on Approach1==============================================================
Note: 2d board is not used and only list is used. because list index taken as row.

1) Here in this problem requirement, no need to generate the board with queen. All we need is possible count.
2) For each row, try to place queen without violation on col/ Diagonal/ AntiDiagonal.
If row reached "n". Then we found a combination.

Note: Try to understand/imagine point3. It is very important
3) Row check not needed, because when I place a queen, I move to next row. Previous rows are filled properly.

4) Col check simply verify whether already occupied in occupiedColumns.

 			[0,0,0]
 			[0,Q,0]
 			[0,0,0]

5) Diagonal     Placement==>  row+col -->Ex: Place Queen in 1,1(2) --> Verify 2,0(2+0) and 0,2(0+2)
Verify whether Diagonal already occupied in occupiedDiagonals.

6) AntiDiagonal Placement==>  row-col -->Ex: Place Queen in 1,1(0) --> Verify 0,0(0-0) and 2,2(2-2)
Verify whether AntiDiagonal already occupied in occupiedAntiDiagonals.

7) If there is no conflicts coloumn-wise/diagonal-wise/anti-diagonal-wise. Queen can be placed in that position.

8) Move on to next row. from col position 0.
================================================================================================================================
 */
public class NQueensII {

  private final Set<Integer> dpColumns = new HashSet<>(); // -------------columns |
  private final Set<Integer> dpDiagonals = new HashSet<>(); // ----anti-diagonals /
  private final Set<Integer> dpAntiDiagonals = new HashSet<>(); // -----diagonals \

  public int totalNQueens(int n) {
    totalNQueensHelper(0, n);
    return count;
  }

  int count = 0;

  private void totalNQueensHelper(int row, int n) {
    if (row == n) {
      count++; // row reached "n". We found a combination.
      return;
    }
    for (int col = 0; col < n; col++) {
      if (dpColumns.contains(col)) continue;

      int diagonal = row + col;
      if (dpDiagonals.contains(row + col)) continue;

      int antiDiagonal = row - col;
      if (dpAntiDiagonals.contains(row - col)) continue;

      dpColumns.add(col);
      dpAntiDiagonals.add(antiDiagonal);
      dpDiagonals.add(diagonal);

      totalNQueensHelper(row + 1, n);

      dpColumns.remove(col);
      dpAntiDiagonals.remove(antiDiagonal);
      dpDiagonals.remove(diagonal);
    }
  }
}
