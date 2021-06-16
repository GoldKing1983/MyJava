package com.interview.leetcode.amazon.medium;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/minesweeper/

See MinesweeperBFS
 */
public class MinesweeperBFS {
  // 8 directions
  private static final int[][] DIRECTIONS =
      new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

  public char[][] updateBoard(char[][] board, int[] click) {
    int maxRow = board.length, maxCol = board[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(click);
    if (board[click[0]][click[1]] == 'M') { // Mine
      board[click[0]][click[1]] = 'X';
      return board;
    }

    while (!queue.isEmpty()) {
      int[] currentPosition = queue.poll();
      int currentRow = currentPosition[0], currentCol = currentPosition[1];
      int count = 0;
      // If the currentCell is anything other than 'E' no operation is required
      if (board[currentRow][currentCol] != 'E') continue;

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

        queue.offer(new int[] {nextRow, nextCol});
      }
    }

    return board;
  }
}
