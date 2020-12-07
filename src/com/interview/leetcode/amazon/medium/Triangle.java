package com.interview.leetcode.amazon.medium;

import java.util.List;

/*
 * https://leetcode.com/problems/triangle/

1) Given a triangle, find the minimum path sum from top to bottom.
2) Each step you may move to adjacent numbers on the row below.

==========================Solution Approach===============================
Input:
			 [-1],
			 [2,3],
			[1,-1,-3]]
Output: -1
	Path1 : -1 -> 2 -> -1 = 0
	Path2 : -1 -> 3 -> -3 = -1

Step1: updating row1 from row0
				-1
			  1		2
		   1    -1    -3
Step2: updating row2 from row1
				-1
			  1		2
		   2   (0,1)  -1    ==>Math.min(0,1) will be placed
		   2      0     -1  ==>So it would be

So first and last don't have comparism rest all index needs Math.min logic.

Trick: So If I look from bottom view, to fill 2,1... I need  to do -->min of (1,0 and 1,1)+ 2,1.
Thats it now code it.

1) Process each row...
2) Update first column and last column directly.
3) Update middle column based on previous row min.
4) So last row will has possible path minimum. Pick the minimum by iterating.

 */
public class Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    // don't want to change the source, so using this array.
    // The array has so many left spaces because of triangle structure.
    Integer dp[][] = new Integer[n][n];
    // Save the first row of data. So that i-1 will not fail.
    dp[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> currentRow = triangle.get(i);
      for (int j = 1; j < currentRow.size() - 1; j++) {
        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + currentRow.get(j);
      }
      dp[i][0] = currentRow.get(0) + dp[i - 1][0]; // for first column
      dp[i][i] = currentRow.get(i) + dp[i - 1][i - 1]; // for last column
    }
    // Answer will be in last row with minimum
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      min = Math.min(min, dp[n - 1][i]);
    }
    return min;
  }
}
