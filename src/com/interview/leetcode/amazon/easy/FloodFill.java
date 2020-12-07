package com.interview.leetcode.amazon.easy;

/*
 https://leetcode.com/problems/flood-fill/
==============================================Requirement==============================================
 1) Go in all the 4 direction, if oldColor is present in that index. Update the index with newColor.
 2) Recursion stops if don't see "oldColor" in any of "current" or "4 adjacent sides"
 3) Comparing to NumberOfIsland.
 		a) In NumberOfIsland recursion startsWith 1 in current. "current" and 4 "adjacentSide" is updated to 0(1 to 0 or 0 to 0).
 		Recursion stops if it sees 0.
		b) Here recursion startsWith oldColor in current. "current" and 4 "adjacentSide" is updated to newColor,
		 only if current/4 adjacentSide is oldColor. Recursion stops if it sees anything other than oldColor.
		 So during the start of the recursion itself, if newColor is startIndex, then return input directly.

Ex: newColor=2, sr=1, sc=1
Here oldColor is 1 which is at index 1,1.
Update all 1(oldColor) in 4 direction to newColor 2 recursively.
	[1,1,1],
	[1,1,0],
	[1,0,1]]

Output:
	[2,2,2],
	[2,2,0],
	[2,0,1]]
0 cannot be updated because oldColor is 1.
1 at index (2,2) cannot be updated, because recursion cannot go through 0.

*/
public class FloodFill {

  // going clockwise --> 0: 'right', 1: 'down', 2: 'left',  3: 'up'
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int[][] floodFill(int[][] image, int row, int col, int newColor) {
    if (image[row][col] == newColor) return image;
    recur(image, row, col, image.length, image[0].length, image[row][col], newColor);
    return image;
  }

  private void recur(
      int[][] image, int row, int col, int rowMax, int colMax, int oldColor, int newColor) {

    image[row][col] = newColor;
    for (int i = 0; i < 4; i++) {
      int nextRow = row + DIRECTIONS[i][0];
      int nextCol = col + DIRECTIONS[i][1];
      if (nextRow == rowMax
          || nextCol == colMax
          || nextRow < 0
          || nextCol < 0
          || image[nextRow][nextCol] != oldColor) continue;

      recur(image, nextRow, nextCol, rowMax, colMax, oldColor, newColor);
    }
  }
}
