package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/max-increase-to-keep-city-skyline/
======================================================Problem Analysis===========================================================
Ex:
        1 2 3 
        4 5 6
        7 8 9
1) I want to increase the building height, but without affecting the view from all sides.
2) Lets take position, "1"...I want to increase its height. 
    
    if I view from top, highest building is 7  
    if I view from bottom, highest building is 7
    if I view from left, highest building is 3
    if I view from right, highest building is 3  

So If I change "1" to "7" the "skyline" will change for leftView and rightView, whereas topView and bottomView remains same as "7".
But as per requirement, I cannot change "skyline", but still need to increase building height as much as possible.
So If I change "1" to "3", then "skyline" remains same in all 4 views.
=====================================================Solution Approach===========================================================

1) Problem is about, I need to increase a matrix point to max. But it cannot go beyond the max
horizontally and vertically.
2) So iterate matrix and save maxRow and maxCol
	Ex: For below input
		1 2 3 
		4 5 6
        7 8 9
    maxRowsCol = [3, 6, 9]
	maxColsVal = [7, 8, 9]

	Now for [0,0] point I can increase it to 3 or 7 max. Since it cannot go beyond any 1. 3 is the answer.
	So now I can increase 1 to 3 = 2
						  2 to 3 = 1
						  3 to 3 = 0
						  4 to 6 = 2
						  5 to 6 = 1
						  6 to 6 = 0
						  7 to 7 = 0
						  8 to 8 = 0
						  9 to 9 = 0
						          ===
						  Answer = 6
						          ===
Note: Coding Challenge. Updating "maxRowsCol" and "maxColsVal" at the same time in single loop is challenge.

*/
public class MaxIncreaseToKeepCitySkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int maxRow = grid.length;
    int maxCol = grid[0].length;

    int[] maxRowVol = new int[maxRow];
    int[] maxColVal = new int[maxCol];

    int count = 0;

    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        int currentValue = grid[row][col];
        maxRowVol[row] = Math.max(maxRowVol[row], currentValue);
        maxColVal[col] = Math.max(maxColVal[col], currentValue);
      }
    }

    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        count += Math.min(maxRowVol[i], maxColVal[j]) - grid[i][j];
      }
    }

    return count;
  }
}
