package com.interview.leetcode.topic.dfs;

/*

https://leetcode.com/problems/where-will-the-ball-fall/
========================================================Solution Approach========================================================
1) If the "currentPoint"(row,col) is 1 then the "nextPoint" in the sameRow(row,col+1) must also be 1.
         --- ---  
        | \a| \b| --> a is currentPoint and b is nextPoint
         --- ---
Then do dfs for "nextRow, nextCol" (row+1,col+1)
         --- ---  
        | \ | \ |
         --- ---
            |dfs|
             ---
2) If the "currentPoint"(row,col) is -1 then the "previousPoint" in the sameRow(row,col-1) must also be -1.
         --- ---  
        | /b| /a| --> a is currentPoint and b is previousPoint
         --- ---
Then do dfs for "nextRow, prevCol" (row+1,col-1)
         --- ---  
        | / | / |
         --- ---
        |dfs|
         ---

3) If any of the condition fail or goes out of bounds that ball won't reach the end.

 */
public class WhereWillTheBallFall {
  public int dfs(int[][] grid, int row, int maxRow, int col, int maxCol) {
    if (row == maxRow) return col; // ball reached lastRow successfully. 

    if (grid[row][col] == 1 && col + 1 < maxCol && grid[row][col + 1] == 1)
      return dfs(grid, row + 1, maxRow, col + 1, maxCol);

    else if (grid[row][col] == -1 && col - 1 >= 0 && grid[row][col - 1] == -1)
      return dfs(grid, row + 1, maxRow, col - 1, maxCol);

    return -1;
  }

  public int[] findBall(int[][] grid) {
    int maxRow = grid.length, maxCol = grid[0].length;
    int[] ar = new int[maxCol];

    for (int j = 0; j < maxCol; j++) {
      ar[j] = dfs(grid, 0, maxRow, j, maxCol);
    }

    return ar;
  }
}
