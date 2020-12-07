package com.interview.leetcode.google.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/*

If you think of modifying the algorithm with visited logic to try eliminate TLE.
Then it would change into GREEDY and fail in below case.

[1,-3,3],
[0,-2,0],
[-3,-3,-3]]
Expected : 3

===============Below code Outputs 5 due to greedy=================================
Current Row and Col 0,0
Current Row and Col 1,0
Current Row and Col 1,1
Current Row and Col 1,2
Current Row and Col 2,0
Current Row and Col 0,1
Current Row and Col 0,2
Current Row and Col 2,1
Current Row and Col 2,2


*/
public class DungeonGameDijkstraWithVisited {
  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon.length == 0) return 0;

    int maxRow = dungeon.length - 1;
    int maxCol = dungeon[0].length - 1;

    Queue<int[]> pQ = new PriorityQueue<>((a, b) -> b[2] - a[2]);

    pQ.offer(new int[] {0, 0, dungeon[0][0], dungeon[0][0]});
    boolean[][] visited = new boolean[maxRow + 1][maxCol + 1];
    visited[0][0] = true;
    while (true) {
      int[] current = pQ.poll();
      int row = current[0];
      int col = current[1];
      int currentHealth = current[2];
      int healthMaxNeeded = current[3];
      if (row == maxRow && col == maxCol) {
        // Input : [[100]] Output: 1 --- Input : [[-100]] Output: 101
        return healthMaxNeeded > 0 ? 1 : Math.abs(healthMaxNeeded) + 1;
      }
      if (row + 1 <= maxRow && !visited[row + 1][col]) {
        visited[row + 1][col] = true;
        int currentHealthUpdated = currentHealth + dungeon[row + 1][col];
        int healthMaxNeededUpdated = Math.min(healthMaxNeeded, currentHealthUpdated);
        pQ.offer(new int[] {row + 1, col, currentHealthUpdated, healthMaxNeededUpdated});
      }
      if (col + 1 <= maxCol && !visited[row][col + 1]) {
        visited[row][col + 1] = true;
        int currentHealthUpdated = currentHealth + dungeon[row][col + 1];
        int healthMaxNeededUpdated = Math.min(healthMaxNeeded, currentHealthUpdated);
        pQ.offer(new int[] {row, col + 1, currentHealthUpdated, healthMaxNeededUpdated});
      }
    }
  }
}
