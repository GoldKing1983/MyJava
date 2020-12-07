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
ordr
ordr
					==========1b added for each 1 i.e if a 1 cannot go anywhere in 4 direction then a "b" will be added==========
With "b" added
ordrbbbb
ordbrbbb
==============================================================================================================
[[1,1,0,1,1],
 [1,0,0,0,0],
 [0,0,0,0,1],
 [1,1,0,1,1]]
				    ==========1b added for each 1 i.e if a 1 cannot go anywhere in 4 direction then a "b" will be added==========
 odbrbb
 orbb
 odlbbb
 orbb
==============================================================================================================

 */
public class NumberOfDistinctIslands {
  public int numDistinctIslands(int[][] grid) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] != 0) {
          StringBuilder sb = new StringBuilder();
          dfs(grid, i, j, sb, "o"); // origin
          grid[i][j] = 0;
          set.add(sb.toString());
        }
      }
    }
    return set.size();
  }

  private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) return;
    sb.append(dir);
    // updating source to 0, to avoid revisit.
    grid[i][j] = 0;
    dfs(grid, i - 1, j, sb, "u"); // up
    dfs(grid, i + 1, j, sb, "d"); // down
    dfs(grid, i, j - 1, sb, "l"); // left
    dfs(grid, i, j + 1, sb, "r"); // right
    sb.append("b"); // back,, it is not about backtracking
  }
}
