package com.interview.leetcode.topic.matrix;

public class DungeonGameTopLeftToBottomRightWorstSolution {
  public int calculateMinimumHP(int[][] dungeon) {
    int width = dungeon.length;
    int height = dungeon[0].length;
    int minCostArray[][] = new int[width][height];
    int minKnightBlood[][] = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (i == 0 && j == 0) {
          minCostArray[i][j] = dungeon[i][j];
          minKnightBlood[i][j] = Math.max(1 - minCostArray[i][j], 1);
        } else if (i == 0) {
          minCostArray[i][j] = minCostArray[i][j - 1] + dungeon[i][j];
          minKnightBlood[i][j] = Math.max(minKnightBlood[i][j - 1], 1 - minCostArray[i][j]);
        } else if (j == 0) {
          minCostArray[i][j] = minCostArray[i - 1][j] + dungeon[i][j];
          minKnightBlood[i][j] = Math.max(minKnightBlood[i - 1][j], 1 - minCostArray[i][j]);
        } else {

          minCostArray[i][j] =
              Math.max(minCostArray[i - 1][j], minCostArray[i][j - 1]) + dungeon[i][j];
          minKnightBlood[i][j] =
              Math.min(
                  Math.max(minKnightBlood[i - 1][j], 1 - minCostArray[i - 1][j] - dungeon[i][j]),
                  Math.max(minKnightBlood[i][j - 1], 1 - minCostArray[i][j - 1] - dungeon[i][j]));
          if (minCostArray[i][j] == 0) minCostArray[i][j] = -1;
        }
      }
    }

    return minKnightBlood[width - 1][height - 1];
  }
}
