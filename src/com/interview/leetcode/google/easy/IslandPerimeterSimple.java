package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).

Determine the perimeter of the island.
=============Note: This problem doesn't related to counting numberOfConnectedIsland or recursion... it is a easy problem=============
Ex1:
		[1 1]
		[1 0]
Output: 8
				 __ __
				|   __|
				|__|

dp=		[2 3]
		[3 0]
Count all the values islandPerimeter=8

Ex2:
		[1 0]
		[0 0]
Output: 4
				 __
				|__|

dp=		[4 0]
		[0 0]
Count all the values islandPerimeter=4

Ex3:
		[1 0]
		[1 0]
Output: 6
				 __
				|  |
				|__|

dp=		[3 0]
		[3 0]
Count all the values islandPerimeter=6

==========================================================Solution Approach==========================================================
1) Add 4 for island. 
2) For the connectedIsland. If UP    is island decrement-1
                            If DOWN  is island decrement-1
                            If LEFT  is island decrement-1
                            If RIGHT is island decrement-1

======================================================================================================================================

 */
public class IslandPerimeterSimple {
  public int islandPerimeter(int[][] grid) {
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
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
            islandPerimeter -= 1;
          }
        }
      }
    }
    return islandPerimeter;
  }
}
