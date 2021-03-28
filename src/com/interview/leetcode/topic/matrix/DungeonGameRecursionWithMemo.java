package com.interview.leetcode.topic.matrix;

/*
https://leetcode.com/problems/dungeon-game/

1) Very old question and overly framed with stories.
2) From [0,0] to [n-1,n-1] reach with minimal path.

Priority Queue Approach : Like diktstra https://leetcode.com/problems/dungeon-game/discuss/546200/simple-java-Solution


Input : [[100]] Output: 1
Input : [[1000]] Output: 1
Input : [[-200]] Output: 201
 */
public class DungeonGameRecursionWithMemo {
  private int[][] dp;
  private boolean[][] visited;

  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon.length == 0) return 0;
    int maxRow = dungeon.length;
    int maxCol = dungeon[0].length;
    dp = new int[maxRow][maxCol];
    visited = new boolean[maxRow][maxCol];
    int required = dfs(dungeon, maxRow, maxCol, 0, 0);

    // for(int[] d : dp)
    //     System.out.println(Arrays.toString(d));
    return required < 0 ? Math.abs(required) + 1 : 1;
  }

  private int dfs(int[][] cells, int maxRow, int maxCol, int row, int col) {

    if (visited[row][col]) return dp[row][col];
    visited[row][col] = true;
    if (row + 1 == maxRow && col + 1 == maxCol) { // Base Condition, where queen is present.
      dp[row][col] = cells[row][col] > 0 ? 0 : cells[row][col];
      return dp[row][col];
    }
    int left = row + 1 < maxRow ? dfs(cells, maxRow, maxCol, row + 1, col) : Integer.MIN_VALUE;
    int right = col + 1 < maxCol ? dfs(cells, maxRow, maxCol, row, col + 1) : Integer.MIN_VALUE;
    int ans = Math.max(left, right);

    ans = cells[row][col] + ans;
    dp[row][col] = ans > 0 ? 0 : ans;
    return dp[row][col];
  }
}
