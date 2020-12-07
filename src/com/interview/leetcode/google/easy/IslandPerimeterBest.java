package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).

Determine the perimeter of the island.

=============Note: This problem doesn't related to counting numberOfConnectedIsland or recursion... it is a easy problem=========
See the video https://leetcode.com/problems/island-perimeter/solution/
1) Similar to IslandPerimeterSimple.
      =========Solution Approach1=========
2) I can look only UP and, LEFT..
      2a) Add 4 for island. 
      2b) if UP   present. decrement -2.
      2c) if LEFT present. decrement -2.
      =========Solution Approach2=========
3) I can look only RIGHT and, DOWN..
      2a) Add 4 for island. 
      2b) if RIGHT present. decrement -2.
      2c) if DOWN  present. decrement -2.

 */
public class IslandPerimeterBest {
  public int islandPerimeter(int[][] grid) {
    //int[][] dirs = new int[][] {{0, 1}, {1, 0}}; // RIGHT AND DOWN
    int[][] dirs = new int[][] {{-1, 0}, {0, -1}}; // UP And LEFT
    int rowMax = grid.length, colMax = grid[0].length;
    int islandPerimeter = 0;
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == 1) {
          islandPerimeter += 4;
          for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow == rowMax || nextRow < 0 || nextCol == colMax || nextCol < 0) continue;
            if (grid[nextRow][nextCol] == 0) continue;
            islandPerimeter -= 2;
          }
        }
      }
    }
    return islandPerimeter;
  }
}
