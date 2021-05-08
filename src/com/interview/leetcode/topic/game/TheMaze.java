package com.interview.leetcode.topic.game;

/*
https://leetcode.com/problems/the-maze/description/

===========================================================Requirement===========================================================
1) Given the ball's start position, the destination and the maze.
2) determine whether the ball could stop at the destination.
=============Difference between "Island Problem" and this==================
1) Ball moves "all the way to end till blocked or cannot move further" from 4 direction. 
So it is not a step by step move like other DFS.
2) So for below input,
when it starts with (0,0)... Next Right is (0,2) and not (0,1).
when it starts with (0,0)... Next Down is (2,0) and not (1,0).

3)So for below input, "hasPath" is false. Because it loops at "rectangle" (0,0) ==> (0,2) ==> (1,2) ==> (1,0)

 Ex: start = 0,0 --> destination = 2,1 --> hasPath=false
 			0 0 0
  			0 0 0
     		1 0 1
========================================================Solution Approach========================================================
1) Navigate from start position and traverse 4 direction
1a) 1 trick is Traverse all the way for each direction and it is not a step by step move like other DFS.
2) Mark Visited node to true.
3) Place traversed 4 direction in stack or queue and iterate till stack or queue is empty.
4) Check destination reached before loop
======BackTracking is not required===========================================
*/
public class TheMaze {

  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    visited[start[0]][start[1]] = true;
    return dfs(maze, start[0], start[1], destination[0], destination[1], maze.length,
        maze[0].length, visited);
  }

  private boolean dfs(int[][] maze, int sourceRow, int sourceCol, int destinationRow,
      int destinationCol, int maxRow, int maxCol, boolean[][] visited) {
    if (sourceRow == destinationRow && sourceCol == destinationCol) {
      return true;
    }
    for (int i = 0; i < DIRECTIONS.length; i++) {
      // When we see nextPoint is deadEnd or blocked(1), then we need previousRowCol to add it to dfs 
      int cacheNextRow = sourceRow;
      int cacheNextCol = sourceCol;

      while (true) {
        int nextRow = cacheNextRow + DIRECTIONS[i][0];
        int nextCol = cacheNextCol + DIRECTIONS[i][1];

        // if nextPoint is end or block. Then currentPoint is eligible for dfs, if it is not visited already
        // or we can say, if nextPoint is 0 move further in sameDirection. 
        if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0
            || maze[nextRow][nextCol] == 1)
          break;

        cacheNextRow = nextRow;
        cacheNextCol = nextCol;
      }

      if (visited[cacheNextRow][cacheNextCol]) continue;

      visited[cacheNextRow][cacheNextCol] = true;

      if (dfs(maze, cacheNextRow, cacheNextCol, destinationRow, destinationCol, maxRow, maxCol,
          visited)) {
        return true;
      }

    }
    return false;
  }


}
