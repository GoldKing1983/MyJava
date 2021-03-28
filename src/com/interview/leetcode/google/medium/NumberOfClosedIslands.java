package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/number-of-closed-islands/

Find 0 surrounded by 1s (left, top, right, bottom).
=========Solution Approach==================================
1) DFS is called only for 0's from outer for loop.
2) Inside the DFS.
2a) Go in all 4 direction, change 0 to 1 to mark it as visited.
2b) If any direction is 1 return true.
2c) If all the direction returns true, then return true.
=====================Consider 2 as 0 changed to 1 for understanding===========================================================
Input:
[[0,0,1,0,0],
 [0,1,0,1,0],
 [0,0,1,0,0]]
Output:1

[2, 2, 1, 0, 0]
[2, 1, 0, 1, 0]
[2, 2, 1, 0, 0]
Visit done for location 0,0. Closed Island: 0
[2, 2, 1, 2, 2]
[2, 1, 0, 1, 2]
[2, 2, 1, 2, 2]
Visit done for location 0,3. Closed Island: 0
[2, 2, 1, 2, 2]
[2, 1, 2, 1, 2]
[2, 2, 1, 2, 2]
Visit done for location 1,2. Closed Island: 1
=================================================================================================================================
Input:
[[0,0,0,0,0],
 [0,1,0,1,0],
 [0,0,1,0,0]]
Output:0

[2, 2, 2, 2, 2]
[2, 1, 2, 1, 2]
[2, 2, 1, 2, 2]
Visit done for location 0,0. Closed Island: 0

=================================================================================================================================

[[1,1,1,1,1],
 [1,0,0,0,1],
 [1,0,0,0,1],
 [1,0,0,0,1],
 [1,1,1,1,1]]
 Output:1

[1, 1, 1, 1, 1]
[1, 2, 2, 2, 1]
[1, 2, 2, 2, 1]
[1, 2, 2, 2, 1]
[1, 1, 1, 1, 1]
Visit done for location 1,1. Closed Island: 1
=================================================================================================================================

[[1,1,1,1,1],
 [1,0,0,0,1],
 [1,0,1,0,1],
 [1,0,0,0,1],
 [1,1,1,1,1]]
 Output:1

 */
public class NumberOfClosedIslands {
  // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
  private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public int closedIsland(int[][] grid) {
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          if (dfs(i, j, grid)) res++;
        }
      }
    }

    return res;
  }

  /*
  If someone asks for don't change the source. Then change 0 to 2.
  At the end again change 2 to 0.
   */
  public boolean dfs(int x, int y, int[][] grid) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
    if (grid[x][y] == 1) return true;
    grid[x][y] = 1; // mark 0 as visited by changing it to 2.
    boolean up = dfs(x - 1, y, grid);
    boolean down = dfs(x + 1, y, grid);
    boolean left = dfs(x, y - 1, grid);
    boolean right = dfs(x, y + 1, grid);
    return up && down && left && right;
  }
}
