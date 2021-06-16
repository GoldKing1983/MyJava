package com.interview.leetcode.amazon.easy;

/*
 https://leetcode.com/problems/flood-fill/
===========================================================Requirement===========================================================
 1) Given a matrix with startRow,startCol and newColor.
 2) Pick the value at startRow,startCol as name it as sourceColor.
 3) With startRow,startCol as initial point update all connected points to newColor 
============================================================Example1=============================================================
Ex: newColor=2, sr=1, sc=1
Here sourceColor is 1 which is at index 1,1.
Update all 1(sourceColor) in 4 direction to newColor 2 recursively.
	[1,1,1],
	[1,1,0],
	[1,0,1]]

Output:
	[2,2,2],
	[2,2,0],
	[2,0,1]]
0 cannot be updated because sourceColor is 1.
1 at index (2,2) cannot be updated, because recursion cannot go through 0.

========================================================Solution Approach========================================================
Similar to NumberOfIsland

*/
public class FloodFill {

  // going clockwise --> 0: 'right', 1: 'down', 2: 'left',  3: 'up'
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int[][] floodFill(int[][] image, int row, int col, int newColor) {
    int sourceColor = image[row][col], maxRow = image.length, maxCol = image[0].length;
    
    if (sourceColor == newColor) return image;
    
    dfs(image, row, col, maxRow, maxCol, sourceColor, newColor);
    
    return image;
  }

  private void dfs(int[][] image, int row, int col, int maxRow, int maxCol, int sourceColor,
      int newColor) {

    image[row][col] = newColor;
    for (int i = 0; i < 4; i++) {
      int nextRow = row + DIRECTIONS[i][0];
      int nextCol = col + DIRECTIONS[i][1];
      if (nextRow == maxRow || nextCol == maxCol || nextRow < 0 || nextCol < 0) continue;
      if (image[nextRow][nextCol] != sourceColor) continue;

      dfs(image, nextRow, nextCol, maxRow, maxCol, sourceColor, newColor);
    }
  }
}
