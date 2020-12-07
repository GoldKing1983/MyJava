package com.interview.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/minesweeper/

M - Mine
E - Empty - (Empty will transform into "B" if no Mine surrounded  or "number" that says count of Mine) 
B - BlankSquare 

1) If currentClick  "step on a mine" ('M'), mark it as 'X' return result.
2) There-after code is smart enough to "not step on mine". So it is about winning only and filling all the matrix. 

2) If click on an empty cell ('E'), further traversal, depends on surrounding mine:
2.1 if there are any mine(s) in ('M') 8 directions, mark it with count of surrounding mine(s), stop further search.
2.2 if surrounding no  mine(s), mark it as 'B', continue search its 8 neighbors.


 */
public class Minesweeper {
  // 8 directions
  private static final int[][] DIRECTIONS =
      new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

  public char[][] updateBoard(char[][] board, int[] click) {
    int maxRow = board.length, maxCol = board[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(click);
    boolean[][] visited = new boolean[maxRow][maxCol];
    if (board[click[0]][click[1]] == 'M') { // Mine
      board[click[0]][click[1]] = 'X';
      return board;
    }

    while (!queue.isEmpty()) {
      int[] currentPosition = queue.poll();
      int currentRow = currentPosition[0], currentCol = currentPosition[1];
      int count = 0;

      //=============count the number of mines around a point in 8 directions=============  
      for (int[] direction : DIRECTIONS) {
        int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
        if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
        if (board[nextRow][nextCol] == 'M') count++;
      }

      if (count > 0) { // If there are mines around currentPosition, stop further BFS. Update currentPosition with mineCount.
        board[currentRow][currentCol] = (char) (count + '0');
        continue;
      }
      //=============traverse in next 8 directions for the valid nextPosition=============  
      board[currentRow][currentCol] = 'B';

      for (int[] direction : DIRECTIONS) {
        int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
        if (nextRow < 0 || nextRow == maxRow || nextCol < 0 || nextCol == maxCol) continue;
        if (visited[nextRow][nextCol]) continue;
        visited[nextRow][nextCol] = true;

        if (board[nextRow][nextCol] != 'E') continue;
        queue.offer(new int[] {nextRow, nextCol});


      }
    }

    return board;
  }
}
