package com.interview.leetcode.topic.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/

=======================================Requirement=======================================
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is not possible, return -1 instead.
====================================Solution Approach: Simple BFS================
1) It is not DFS. It is BFS.
2) Each level on 4 direction is each minute.
3) Count total number of rottenFruits and push it to queue.
4) Count total number of freshFruits. It is required for 2 cases.
Case1: If there are no freshFruits, we can exit right away.
Case2: Even after x days, freshFruits kept away from rottenFruits are always fresh. Ex: ["rotten", "empty", "fresh"]
5) Push the rottenFruits into Queue.
6) For Each Minute, poll all the rottenFruits and offer corresponding freshFruits.
7) Visited is avoided by updating grid[nextRow][nextCol] to 2. i.e if it is 2 already don't visit again.
 */
public class AmazonOnlineTest2RottingOranges {

  private static final int[][] DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int orangesRotting(int[][] grid) {
    Queue<int[]> q = new LinkedList<>();
    int rowMax = grid.length;
    int colMax = grid[0].length;
    int freshOrangeCount = 0;
    int noOfDaysToRottenAllOrange = 0;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == 2) {
          q.offer(new int[] {row, col});
          grid[row][col] = 0;
        } else if (grid[row][col] == 1) freshOrangeCount++;
      }
    }
    if (freshOrangeCount == 0) return 0;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int[] currentPos = q.poll();
        int row = currentPos[0];
        int col = currentPos[1];
        for (int[] dir : DIRECTIONS) {
          int nextRow = dir[0] + row;
          int nextCol = dir[1] + col;
          if (nextRow == rowMax || nextRow < 0 || nextCol == colMax || nextCol < 0) continue;
          if (grid[nextRow][nextCol] == 0) continue;
          if (grid[nextRow][nextCol] == 1) {
            freshOrangeCount--;
            grid[nextRow][nextCol] = 0;
            q.offer(new int[] {nextRow, nextCol});
          }
        }
      }
      noOfDaysToRottenAllOrange++;
      // Return as soon as freshOrangeCount == 0. Because there might be rottenOrange still left at random positions.
      // But noFreshOrange is present.
      if (freshOrangeCount == 0) return noOfDaysToRottenAllOrange;
    }
    return -1;
  }
}
