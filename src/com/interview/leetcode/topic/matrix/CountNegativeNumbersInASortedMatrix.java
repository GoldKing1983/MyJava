package com.interview.leetcode.topic.matrix;

/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 
return the number of negative numbers in grid.

input:
    4   3   2   -1
    3   2   1   -1
    1   1   -1  -2

output: 4
====Solution Common Point====
1) Remember the reverse-z
2) So 2 solution possible. topRightCorner to bottomLeftCorner or bottomLeftCorner to topRightCorner

                     -------
                    |
                    |
                    |
             -------
====Solution approach topRightCorner to bottomLeftCorner====
1) start traversal from topRightCorner.
2) If currentElement is negative, then all bottom must also be negative. 
   So capture result(remainingHeight). Move leftSide(previousColumn). 
3) Else Move bottom (nextRow).
   
====Solution approach bottomLeftCorner to topRightCorner====
1) start traversal from bottomLeftCorner.
2) If currentElement is >= 0 then all top must be greater. So moveRight(nextCol). 
3) Else. currentElement is negative and everything after that is negative. 
   So capture result(restOfWidth). Move Up (previousRow).

=========================================================Time Complexity=========================================================
O(m+n)
 */
public class CountNegativeNumbersInASortedMatrix {
  public int countNegativesStartFromTopRightCorner(int[][] grid) {
    int res = 0;
    int maxRow = grid.length;
    int maxCol = grid[0].length;
    int row = 0;
    int col = maxCol - 1;
    while (row < maxRow && col >= 0) {
      if (grid[row][col] < 0) {
        res += maxRow - row;
        col--;
      } else {
        row++;
      }
    }
    return res;
  }

  public int countNegativesStartFromBottomLeftCorner(int[][] grid) {
    int res = 0;
    int maxRow = grid.length;
    int maxCol = grid[0].length;
    int row = maxRow - 1;
    int col = 0;
    while (row >= 0 && col < maxCol) {
      if (grid[row][col] >= 0) {
        col++;
      } else {
        res += maxCol - col;
        row--;
      }
    }
    return res;
  }

}
