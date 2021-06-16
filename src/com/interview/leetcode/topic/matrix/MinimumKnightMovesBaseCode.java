package com.interview.leetcode.topic.matrix;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/minimum-knight-moves/
===========================================================Requirement===========================================================
1) You have a knight at square [0, 0].
2) A knight has 8 possible moves it can make.
3) Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.

|x| + |y| <= 300

=======================================High Level Thinking==================================================================
1) We can think of this problem as a shortest path problem on a graph: 
there are '300' nodes, each connected in 8 ways and further.
=======================================Solution Approach=====Similar to "OpenTheLock"=============================================================
1) Start with "0,0".
2) Generate next "8 position" for each position.
3) Push all the 8 new combination to queue.
4) If a position is "not visited" then only it can be added to queue.
5) At any-point if "target position" is found return the level.

This code will not cover all test cases. Because it spans on negative side which is symmetric and not needed that makes TLE. 
See "MinimumKnightMovesWorking"
========================================================================================

 */
public class MinimumKnightMovesBaseCode {
  public int minKnightMoves(int x, int y) {
    int[][] direction =
        new int[][] {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {0, 0});
    Set<Integer> visited = new HashSet<>();
    visited.add(0 * 300 + 0);
    int level = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] currentPos = q.poll();
        int currentPosX = currentPos[0];
        int currentPosY = currentPos[1];
        if (visited.contains(currentPosX * 300 + currentPosY)) continue;
        visited.add(currentPosX * 300 + currentPosY);
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
