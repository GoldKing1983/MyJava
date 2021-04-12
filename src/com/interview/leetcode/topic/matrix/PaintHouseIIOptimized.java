package com.interview.leetcode.topic.matrix;

import java.util.Arrays;

/*
1) Same as PaintHouseII
2) Logic to find min1 and min2 for previousRow is implemented using forLoop instead of PriorityQueue Approach.
 */
public class PaintHouseIIOptimized {
  int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min1Index = 0;

  public int minCostII(int[][] costs) {
    int maxRow = costs.length, maxCol = costs[0].length;
    if (maxRow == 0) return 0;
    for (int row = 1; row < maxRow; row++) {
      fillMin1Min2FromPreviousRow(costs[row - 1]);
      for (int col = 0; col < maxCol; col++) {
        costs[row][col] += min1Index == col ? min2 : min1;
      }
      min1 = Integer.MAX_VALUE;
      min2 = Integer.MAX_VALUE;//reset min1 and min2 for next iteration
    }
    return Arrays.stream(costs[maxRow - 1]).min().getAsInt(); // get the min from last row
  }

  private void fillMin1Min2FromPreviousRow(int[] cost) {
    for (int i = 0; i < cost.length; i++) {
      //Ex: 1,2,3
      if (cost[i] <= min1) { // update min1 and min2
        min2 = min1;
        min1 = cost[i];
        min1Index = i;
      } else if (cost[i] <= min2) {
        min2 = cost[i];
      }
    }
  }
}
