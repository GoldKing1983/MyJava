package com.interview.leetcode.amazon.medium;

/*

https://leetcode.com/problems/minesweeper/
===========================================================Requirement===========================================================
1) Initially board can have 'E' or 'M' only.
2) If the initialClick "step on a mine" ('M') then gameOver. 
   Else code should be smart enough to "not step on mine". So it is about winning only and filling the entire matrix.
3) Traverse only for 'E' unRevealedBlankSquare.
   if there are no 'M' around the 'E' then change 'E' to 'B' revealedBlankSquare, do further traversal on 8 directions.    
   if there are    'M' around the 'E' then update 'E' to 'numberOfMines' and stop further traversal.

M - Mine
X - RevealedMine
E - UnReaveledEmptySquare - (Empty will transform into "B" if no Mine surrounded  or "number" that says count of Mine) 
B - RevealedBlankSquare
1-8 - NumberOfMinesAroundACell 
 
========================================================Solution Approach========================================================
Initial Click:
1) If currentClick  "step on a mine" ('M'), mark it as 'X' return result.
2) There-after code is smart enough to "not step on mine". So it is about winning only and filling all the matrix. 

Click ThereAfter: Do DFS
1) If currentCell is anything other than 'E' unRevealedBlankSquare, stop further traversal. This is DFS base condition.
2) Else Count the number of 'M' around the currentCell in 8 directions.
2.1) If there is 'M', mark currentCell with 'numberOfMines', stop further traversal.
3.2) Else mark currentCell as 'B' revealedBlankSquare. 
   For the nextCell in 8 directions traverse further. 


 */
public class MinesweeperDFS {
  // 8 directions
  private static final int[][] DIRECTIONS =
      new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

  public char[][] updateBoard(char[][] board, int[] click) {
    int currentRow = click[0], currentCol = click[1];
    if (board[currentRow][currentCol] == 'M') { // Mine
      board[currentRow][currentCol] = 'X';
      return board;
    }
    dfs(board, click);
    return board;
  }

  private void dfs(char[][] board, int[] click) {
    int maxRow = board.length, maxCol = board[0].length;
    int currentRow = click[0], currentCol = click[1];

    if (board[currentRow][currentCol] != 'E') return; // Base Condition

    int count = 0;// Get number of mines first.
    for (int[] direction : DIRECTIONS) {
      int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
      if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
      if (board[nextRow][nextCol] == 'M') count++;
    }

    if (count > 0) { // If there are mines around currentPosition, stop further BFS. Update currentPosition with mineCount.
      board[currentRow][currentCol] = (char) (count + '0');
    } else {
      //=============traverse in next 8 directions for the valid nextPosition=============  
      board[currentRow][currentCol] = 'B';
      for (int[] direction : DIRECTIONS) {
        int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
        if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
        updateBoard(board, new int[] {nextRow, nextCol});
      }
    }
  }
}
