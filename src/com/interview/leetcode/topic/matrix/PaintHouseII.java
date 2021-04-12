package com.interview.leetcode.topic.matrix;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/paint-house-ii/description/

In PaintHouse, number of row(color) is fixed and number of house is not fixed. Here m color and n houses both are not fixed.

Read PaintHouse.java.
===========================================================BruteForce============================================================
 The brute-force way of doing above logic is
 For a single column, iterate all previous column (skipping current column) and get min.
 This will make nSquare operation for each column of row. To avoid that min1 and min2 is calculated by iterating once for each row.
========================================================Solution Approach========================================================
1) The minimum cost of painting a house with cheap color is minimum cost of painting previous houses, 
2) and make sure the previous house doesn't paint with the same color.

1) Only different logic from PaintHouse is,
 Need to get minimum from previous row, skipping current column of previous row.
 To do that find min1WithColumnIndex and min2WithColumnIndex so that it covers minimum of all the column.
  Ex :
  1 2 3
  4 5 6 -->  from previous row, min1 is [1,0] and min2 is [2,1]

  So when doing calculation,
  1 is skipped for 4, because 4 and 1 are in same column. and 2 is used
  1 is used for 5 
  1 is again used for 6 because index not matched.
=======================================================Data Flow Analysis========================================================
 */
public class PaintHouseII {
  int[] min1Arr = new int[2], min2Arr = new int[2];

  public int minCostII(int[][] costs) {
    int maxRow = costs.length, maxCol = costs[0].length;
    if (maxRow == 0) return 0;
    for (int row = 1; row < maxRow; row++) {
      fillMin1Min2FromPreviousRow(costs[row - 1]);
      for (int col = 0; col < maxCol; col++) {
        costs[row][col] += min1Arr[1] == col ? min2Arr[0] : min1Arr[0];
      }
    }
    return Arrays.stream(costs[maxRow - 1]).min().getAsInt(); // get the min from last row
  }

  private void fillMin1Min2FromPreviousRow(int[] cost) {
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int i = 0; i < cost.length; i++) pQ.offer(new int[] {cost[i], i});
    min1Arr = pQ.poll();
    min2Arr = pQ.poll();
  }
}
