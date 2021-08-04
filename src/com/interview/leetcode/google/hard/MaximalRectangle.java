package com.interview.leetcode.google.hard;

import com.interview.leetcode.topic.array.LargestRectangleInHistogramStackApproach;

/*
 * https://leetcode.com/problems/maximal-rectangle/
https://www.youtube.com/watch?v=g8bSdXCG-lA&t=203s

1) From each row, add currentRow and previousRow, call LargestRectangleInHistogramStackApproach.
 */
public class MaximalRectangle {
  private LargestRectangleInHistogramStackApproach l =
      new LargestRectangleInHistogramStackApproach();

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) return 0;

    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = matrix[i][j] - '0';
        if (dp[i][j] > 0 && i > 0) dp[i][j] += dp[i - 1][j];
      }
    }

    int max = 0;
    for (int[] a : dp) max = Math.max(l.largestRectangleArea(a), max);

    return max;
  }
}
