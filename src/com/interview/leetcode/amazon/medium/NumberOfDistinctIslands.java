package com.interview.leetcode.amazon.medium;

import java.util.HashSet;
import java.util.Set;

/*

https://leetcode.com/problems/number-of-distinct-islands/

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another
if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011

Given the above grid map, return 1.

Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that below 2 are not same
11
1
and
 1
11
=========================================Solution Approach==================================================
[[1,1,0],
 [0,1,1],
 [0,0,0],
 [1,1,1],
 [0,1,0]]

If "b" is not added then result would be
rdr
rdr
					==========add 'b' if we cannot more further in 4 direction or add 'b' at backtracking point==========
With "b" added
rdrbbbb
rdbrbbb
==============================================================================================================
[[1,1,0,1,1],
 [1,0,0,0,0],
 [0,0,0,0,1],
 [1,1,0,1,1]]
				    ==========add 'b' if we cannot more further in 4 direction or add 'b' at backtracking point==========
 dbrbb
 rbb
 dlbbb
 rbb
==============================================================================================================

 */
public class NumberOfDistinctIslands {
  private int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private char[] PATHS = new char[] {'r', 'l', 'd', 'u'};

  public int numDistinctIslands(int[][] grid) {

    int rowMax = grid.length;
    int colMax = grid[0].length;
    Set<String> uniqueIsland = new HashSet<>();
    for (int row = 0; row < rowMax; row++) {
      for (int col = 0; col < colMax; col++) {
        if (grid[row][col] == 1) {
          StringBuilder route = new StringBuilder();
          dfs(grid, row, col, rowMax, colMax, route);
          uniqueIsland.add(route.toString());
        }
      }
    }
    return uniqueIsland.size();
  }

  private void dfs(int[][] grid, int row, int col, int rowMax, int colMax, StringBuilder route) {

    grid[row][col] = 0;

    for (int dir = 0; dir < 4; dir++) {
      int nextRow = DIRECTIONS[dir][0] + row;
      int nextCol = DIRECTIONS[dir][1] + col;
      if (nextRow == rowMax || nextCol == colMax || nextRow < 0 || nextCol < 0) continue;
      if (grid[nextRow][nextCol] == 0) continue;
      route.append(PATHS[dir]);
      dfs(grid, nextRow, nextCol, rowMax, colMax, route);
    }
    route.append('b');
  }
}
