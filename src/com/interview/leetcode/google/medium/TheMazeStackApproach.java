package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* https://leetcode.com/problems/the-maze/description/

========================Requirement===========================================
1) Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
2) Ball moves "all the way to end till blocked or cannot move further" from 4 direction. So it is not a step by step move like other DFS.
So for below input, "hasPath" is false.

 Ex: start = 0,0 --> destination = 2,1 --> hasPath=false
 			0 0 0
  			0 0 0
     		1 0 1

* 1) Navigate from start position and traverse 4 direction
* 1a) 1 trick is Traverse all the way for each direction and it is not a step by step move like other DFS.
* 2) Mark Visited node to true whenever navigation is finished for a position.
* 3) Place traversed 4 direction in stack or queue and iterate till stack or queue is empty.
* 4) Check destination reached before loop
*======BackTracking is not required===========================================
*/
public class TheMazeStackApproach {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    // Queue or Stack both will work
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(start);
    boolean visited[][] = new boolean[maze.length][maze[0].length];
    while (!stack.isEmpty()) {
      start = stack.pop();
      int row = start[0];
      int col = start[1];
      if (destination[0] == row && destination[1] == col) return true;

      if (!visited[row][col]) {
        visited[row][col] = true;

        while (movableLeftToRight(maze, row, col)) ++col;
        stack.push(new int[] {row, col});
        col = start[1]; // column updated so assigning back

        while (movableRightToLeft(maze, row, col)) --col;
        stack.push(new int[] {row, col});
        col = start[1]; // column updated so assigning back

        while (movableTopToBottom(maze, row, col)) ++row;
        stack.push(new int[] {row, col});
        row = start[0]; // row updated so assigning back

        while (movableBottomToTop(maze, row, col)) --row;
        stack.push(new int[] {row, col});
      }
    }

    return false;
  }

  public static boolean movableLeftToRight(int[][] maze, int i, int j) {
    if (j + 1 > (maze[0].length - 1)) return false;
    return maze[i][++j] == 0;
  }

  public static boolean movableRightToLeft(int[][] maze, int i, int j) {
    if (j - 1 < 0) return false;
    return maze[i][--j] == 0;
  }

  public static boolean movableTopToBottom(int[][] maze, int i, int j) {
    if (i + 1 > maze.length - 1) return false;
    return maze[++i][j] == 0;
  }

  public static boolean movableBottomToTop(int[][] maze, int i, int j) {
    if (i - 1 < 0) return false;
    return maze[--i][j] == 0;
  }
}
