package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*


====================================================Additional Logic=====================================================
1) Read MinimumKnightMovesBaseCode.
2) We are calculating move only for topRight and bottomRight. topLeft and bottomLeft are symmetric.
We have to go for 8 sides. But we can ignore negative (to ignore topLeft and bottomLeft).
3) Even ignoring negative has a trick on some cases. So ignore less than "-2"
4) The first move on knight goes to negative, Keep that alone for corner case.. So we keep -2 to INFINITY 
==========================================================================================================================
 */
public class MinimumKnightMovesWorking {
  public int minKnightMoves(int x, int y) {
    x = Math.abs(x);
    y = Math.abs(y);
    int[][] direction =
        new int[][] {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {0, 0});
    Map<Integer, Set<Integer>> visited = new HashMap<>();
    int level = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] currentPoint = q.poll();
        int currentRow = currentPoint[0];
        int currentCol = currentPoint[1];
        if (visited.containsKey(currentRow) && visited.get(currentRow).contains(currentCol))
          continue;
        if (currentRow <= -2 || currentCol <= -2) continue;
        visited.computeIfAbsent(currentRow, v -> new HashSet<>()).add(currentCol);
        if (currentRow == x && currentCol == y) return level;
        for (int j = 0; j < 8; j++) {
          int nextRow = currentRow + direction[j][0];
          int nextCol = currentCol + direction[j][1];
          q.offer(new int[] {nextRow, nextCol});
        }
      }
      level++;
    }
    return -1;
  }
}
