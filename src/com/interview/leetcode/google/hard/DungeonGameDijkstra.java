package com.interview.leetcode.google.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/*

My article on Dijkstra solution
https://leetcode.com/problems/dungeon-game/discuss/725385/The-Big-Question-wandering-everyones-mind-why-not-dikjstra.-Yes-it-is-possible.-Here-is-the-solution

*/
public class DungeonGameDijkstra {
  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon.length == 0) return 0;

    int maxRow = dungeon.length - 1;
    int maxCol = dungeon[0].length - 1;

    Queue<int[]> pQ = new PriorityQueue<>((a, b) -> b[2] - a[2]);

    pQ.offer(new int[] {0, 0, dungeon[0][0], dungeon[0][0]});
    while (true) {
      int[] current = pQ.poll();
      int row = current[0];
      int col = current[1];
      int currentHealth = current[2];
      int healthMaxNeeded = current[3];
      if (row == maxRow && col == maxCol) { // Queen Found. Exit Condition.
        // Input : [[100]] Output: 1 --- Input : [[-100]] Output: 101
        return healthMaxNeeded > 0 ? 1 : Math.abs(healthMaxNeeded) + 1;
      }
      if (row + 1 <= maxRow) { // Down Move is Possible
        int downMoveHealthNeeded = currentHealth + dungeon[row + 1][col];
        int healthMaxNeededUpdated = Math.min(healthMaxNeeded, downMoveHealthNeeded);
        pQ.offer(new int[] {row + 1, col, downMoveHealthNeeded, healthMaxNeededUpdated});
      }
      if (col + 1 <= maxCol) { // Right Move is Possible
        int rightMoveHealthNeeded = currentHealth + dungeon[row][col + 1];
        int healthMaxNeededUpdated = Math.min(healthMaxNeeded, rightMoveHealthNeeded);
        pQ.offer(new int[] {row, col + 1, rightMoveHealthNeeded, healthMaxNeededUpdated});
      }
    }
  }
}
