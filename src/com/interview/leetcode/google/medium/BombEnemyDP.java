package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/bomb-enemy/

Requirement:
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
return the "maximum enemies you can kill using one bomb".
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall,
since the wall is too strong to be destroyed.

Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
Explanation: For the given grid,

0 E 0 0
E 0 W E
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.

Input: [["0","E","0","E","0"],
		["E","0","W","E","E"],
		["0","E","0","0","0"]]
Output: 3
========================================================Solution Approach===================================================
1) Count the leftToRightEnemyCountKilledSoFarBeforeWall for each row.
2) Count the topToBottomEnemyKilledCountSoFarBeforeWall for each col.
3) Max of Sum of 1 and 2 is the answer.
4) dp value for 'wall' and 'enemy' can be anything, because we calculate 'maxEnemyKilled' for '0' in grid only,
for 'W' and 'E' logic is ignored.

Initial DP Array
[0, 0, 0, 0, 0]
[0, 0, 0, 0, 0]
[0, 0, 0, 0, 0]

DP Array after 1st row traversal
[2, 2, 2, 2, 2]
[0, 0, 0, 0, 0]
[0, 0, 0, 0, 0]

DP Array after 2nd row traversal
[2, 2, 2, 2, 2]
[1, 1, 2, 2, 2]
[0, 0, 0, 0, 0]

DP Array after 3rd row traversal
[2, 2, 2, 2, 2]
[1, 1, 2, 2, 2]
[1, 1, 1, 1, 1]

DP Array after 1st col traversal
[3, 2, 2, 2, 2]
[2, 1, 2, 2, 2]
[2, 1, 1, 1, 1]

DP Array after 2nd col traversal
[3, 4, 2, 2, 2]
[2, 3, 2, 2, 2]
[2, 3, 1, 1, 1]

DP Array after 3rd col traversal
[3, 4, 2, 2, 2]
[2, 3, 2, 2, 2]
[2, 3, 1, 1, 1]

DP Array after 4th col traversal
[3, 4, 2, 4, 2]
[2, 3, 2, 4, 2]
[2, 3, 1, 3, 1]

DP Array after 5th col traversal
[3, 4, 2, 4, 3]
[2, 3, 2, 4, 3]
[2, 3, 1, 3, 2]

================================================================================================================
*/
public class BombEnemyDP {
  public int maxKilledEnemies(char[][] grid) {
    int maxRow = grid.length;
    if (maxRow == 0) return 0;
    int maxCol = grid[0].length;

    int[][] dp = new int[maxRow][maxCol];

    for (int row = 0; row < maxRow; row++) {
      for (int left = 0, right = 0; right < maxCol; right++) {
        int leftToRightEnemyCountKilledSoFarBeforeWall = 0;
        // Count maxEnemy can be killed till Wall.
        while (true) {
          if (grid[row][right] == 'E') leftToRightEnemyCountKilledSoFarBeforeWall++;
          right++;
          if (right == maxCol) break;
          if (grid[row][right] == 'W') break;
        }
        // Update DP array with maxEnemy can be killed
        while (true) {
          dp[row][left] += leftToRightEnemyCountKilledSoFarBeforeWall;
          left++;
          if (left == right) break;
        }
      }
    }
    int maxEnemyKilled = 0;
    for (int col = 0; col < maxCol; col++) {
      for (int top = 0, down = 0; down < maxRow; down++) {
        int topToBottomEnemyKilledCountSoFarBeforeWall = 0;
        while (true) {
          if (grid[down][col] == 'E') {
            topToBottomEnemyKilledCountSoFarBeforeWall++;
          }
          down++;
          if (down == maxRow) break;
          if (grid[down][col] == 'W') break;
        }
        while (true) {
          dp[top][col] += topToBottomEnemyKilledCountSoFarBeforeWall;
          // cannot calculate max for 'Wall' and 'Enemy'
          if (grid[top][col] == '0') maxEnemyKilled = Math.max(dp[top][col], maxEnemyKilled);
          top++;
          if (top == down) break;
        }
      }
    }
    return maxEnemyKilled;
  }
}
