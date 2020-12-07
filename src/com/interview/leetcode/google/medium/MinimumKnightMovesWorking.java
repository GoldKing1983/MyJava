package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*


====================================================Additional Logic=====================================================
1) Read MinimumKnightMovesBaseCode.
2) We are calculating for lower and upper side. Upper and Lower side are symmetric.
That doesn't mean we can do it 4 sides of "UP". We have to do for 8 sides. But we can ignore negative.
Even ignoring negative has a trick on some cases. So ignore less than "-2"
3) When negative input comes, change it to positive, because they are symmetric.
3) Hash Logic will work, by changing 300 to 310 and performance is really good.
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
    Set<String> visited = new HashSet<>();
    int level = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] currentPos = q.poll();
        int currentPosX = currentPos[0];
        int currentPosY = currentPos[1];
        if (visited.contains(currentPosX + "," + currentPosY)
            || currentPosX <= -2
            || currentPosY <= -2) continue;
        visited.add(currentPosX + "," + currentPosY);
        if (currentPosX == x && currentPosY == y) return level;
        for (int j = 0; j < 8; j++) {
          int nextPosX = currentPosX + direction[j][0];
          int nextPosY = currentPosY + direction[j][1];
          q.offer(new int[] {nextPosX, nextPosY});
        }
      }
      level++;
    }
    return -1;
  }
}
