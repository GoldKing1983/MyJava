package com.interview.leetcode.topic.game;

/*
* https://leetcode.com/problems/the-maze/description/

=================================================================================================================================
Requirement: Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
=============Difference between "Island Problem" and this==================
1) Ball moves "all the way to end till blocked or cannot move further" from 4 direction. So it is not a step by step move like other DFS.
2) So for below input,
when it starts with (0,0)... Next Right is (0,2) and not (0,1).
when it starts with (0,0)... Next Down is (2,0) and not (1,0).

3)So for below input, "hasPath" is false. Because it loops at "rectangle" (0,0) ==> (0,2) ==> (1,2) ==> (1,0)

 Ex: start = 0,0 --> destination = 2,1 --> hasPath=false
 			0 0 0
  			0 0 0
     		1 0 1
========================================Solution Approach========================================================================
1) Navigate from start position and traverse 4 direction
1a) 1 trick is Traverse all the way for each direction and it is not a step by step move like other DFS.
2) Mark Visited node to true.
3) Place traversed 4 direction in stack or queue and iterate till stack or queue is empty.
4) Check destination reached before loop
======BackTracking is not required===========================================
*/
public class TheMaze {
  private boolean found = false;

  int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    dfs(maze, start[0], start[1], destination[0], destination[1], visited);
    return found;
  }

  private void dfs(
      int[][] maze, int sourceX, int sourceY, int targetX, int targetY, boolean[][] visited) {
    if (visited[sourceX][sourceY]) return;
    if (sourceX == targetX && sourceY == targetY) {
      found = true;
      return;
    }
    visited[sourceX][sourceY] = true;
    for (int i = 0; i < dirs.length; i++) {
      int directionX = dirs[i][0];
      int directionY = dirs[i][1];
      int nextSourceX = sourceX;
      int nextSourceY = sourceY;
      while (isValid(maze, nextSourceX + directionX, nextSourceY + directionY)) {
        nextSourceX += directionX;
        nextSourceY += directionY;
      }
      if (!found) dfs(maze, nextSourceX, nextSourceY, targetX, targetY, visited);
    }
  }

  private boolean isValid(int[][] maze, int row, int col) {
    return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1;
  }
}
