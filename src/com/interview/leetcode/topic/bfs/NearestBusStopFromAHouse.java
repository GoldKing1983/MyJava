package com.interview.leetcode.topic.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://binarysearch.com/problems/Nearest-Bus-Stop-From-a-House
See Also ShortestDistanceFromAllBuildings
===========================================================Requirement===========================================================
You are given a two-dimensional integer matrix containing 0s, 1s, 2s, and 3s where

0 represents an empty cell
1 represents a wall
2 represents a house
3 represents a bus stop

1) Return the shortest distance from any house to any bus stop. 
2) You can move up, down, left, and right but you can't move through a house or a wall cell. If there's no solution, return -1.

============================================================Example1=============================================================
Input
matrix = [
    [2, 1, 3, 0],
    [1, 1, 1, 1],
    [0, 3, 0, 0],
    [0, 0, 0, 2]
]
Output : 3
Explanation : We can go from the house at matrix[3][3] to bus stop at matrix[2][1].
=========================================================Initial Thought=========================================================
1) For each of house find the nearest bus-stop. 
2) do BFS for each of 2 and find distance. 
3) Return the minimum distance of all
========================================================Solution Approach========================================================
1) We don't need to do BFS for each of 2 and find distance.
2) We can add all source i.e house to q.
3) Do BFS - imaging each level...whichever route finds the bus-stop is the nearest bus-stop

Assume a graph node coming to leaf from longDistance and shortDistance. If the shortDistance already took that path, 
then I don't need to visit again for longDistance path. Because finally I need one shortest distance only. 
                           
 */
public class NearestBusStopFromAHouse {
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int solve(int[][] matrix) {

    /*
    For each of house. Do BFS.
    The queue will have currentRow,CurrentCol and distance.
    If bus-stop found. Update minPathDistance with currentDistance.
    Add visited logic to avoid creating another path. The first shortest path wins always. So we can ignore second path. 
            Ex: 
                    2   0  
                    0   0  
            In Above 1,1 can be visited only thorugh one path through 0,1 or 1,0 based on DIRECTION logic
                                                   
    */
    int maxRow = matrix.length, maxCol = matrix[0].length;
    Deque<int[]> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[maxRow][maxCol];
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (matrix[row][col] == 2) {
          q.offer(new int[] {row, col, 0});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] currentPoint = q.poll();
      int currentRow = currentPoint[0];
      int currentCol = currentPoint[1];
      int currentDistance = currentPoint[2];
      for (int[] DIRECTION : DIRECTIONS) {
        int nextRow = DIRECTION[0] + currentRow;
        int nextCol = DIRECTION[1] + currentCol;
        int nextDistance = currentDistance + 1;
        if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0) continue;
        if (visited[nextRow][nextCol]) continue;
        visited[nextRow][nextCol] = true;
        // if next stop is another house or wall, then no operation
        if (matrix[nextRow][nextCol] == 1 || matrix[nextRow][nextCol] == 2) continue;
        // found bus-stop return immediate, as this is the shortest distance
        if (matrix[nextRow][nextCol] == 3) return nextDistance;
        q.offer(new int[] {nextRow, nextCol, nextDistance});
      }
    }
    return -1;
  }
}
