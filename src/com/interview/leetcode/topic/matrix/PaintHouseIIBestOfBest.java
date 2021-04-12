package com.interview.leetcode.topic.matrix;



/*

1) Understand PaintHouseII(O(row*(col log col)) and PaintHouseIIOptimized(O(2*row + 2*col)). 
2) Instead of processing each row 2 times, here at each row, 
we add min1 to eachCol.. min2 to eachCol and update the cost directly
 
 */
public class PaintHouseIIBestOfBest {
  public int minCostII(int[][] costs) {
    int maxRow = costs.length, maxCol = costs[0].length;
    if (maxRow == 0) return 0;
    int min1 = 0, min2 = 0, minIndex = -1;

    for (int row = 0; row < maxRow; row++) {
      int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE, curMinIndex = 0;
      for (int col = 0; col < maxCol; col++) {
        int cost = costs[row][col] + (col == minIndex ? min2 : min1);
        if (cost < curMin1) {
          curMin2 = curMin1;
          curMin1 = cost;
          curMinIndex = col;
        } else if (cost < curMin2) curMin2 = cost;
      }
      min1 = curMin1;
      min2 = curMin2;
      minIndex = curMinIndex;
    }
    return min1;
  }
}
