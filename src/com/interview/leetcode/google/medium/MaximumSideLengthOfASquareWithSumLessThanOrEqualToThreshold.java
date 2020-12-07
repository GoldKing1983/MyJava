package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
https://www.youtube.com/watch?v=xakUTNInEZw

sideLength mean for 3*3 square. 3 is sideLength.
1) Form square anywhere in matrix. If the square sum is <= threshold. Then result length= sideLength.
2) So for a 3*4 matrix. A highest square can be formed is Math.min(3 or 4)=3.


===================================Solution Approach=================================================
1) Generate preSum value for each point.
2) Calculate square sum.
2a) For a row, From left to right, if max already exists, we can skip further processing.
2b)   

===================================Data Flow Analysis=================================================
[
[10,10,10,10],
[10,1,1,1],
[10,1,1,1],
[10,1,1,1]]

Threshold= 9, Output=3

PreSum table for input
	[0, 0, 0, 0, 0]
	[0, 10, 20, 30, 40]
	[0, 20, 31, 42, 53]
	[0, 30, 42, 54, 66]
	[0, 40, 53, 66, 79]

Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:0,0
==Square Sum: 10-0-0+0=10, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:0,1
==Square Sum: 20-10-0+0=10, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:0,2
==Square Sum: 30-20-0+0=10, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:0,3
==Square Sum: 40-30-0+0=10, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:1,0
==Square Sum: 20-0-10+0=10, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:1,1
==Square Sum: 31-20-20+10=1, Threshold is: 9
====Found a result. Square Sum is <= Threshold. So incrementing max side length to 1====
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:1,2
==Square Sum: 42-20-0+0=22, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:1,3
==Square Sum: 53-31-0+0=22, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:2,1
==Square Sum: 42-0-20+0=22, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:2,2
==Square Sum: 54-30-30+10=4, Threshold is: 9
====Found a result. Square Sum is <= Threshold. So incrementing max side length to 2====
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:2,3
==Square Sum: 66-30-0+0=36, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:3,2
==Square Sum: 66-0-30+0=36, Threshold is: 9
Square Sum is > Threshold. So not valid square
====================================================================================
Calculating Square Sum (currentPresum-leftMaxSquarePresum-topMaxSquarePresum+diagonalMaxSquarePresum), for the Position:3,3
==Square Sum: 79-40-40+10=9, Threshold is: 9
====Found a result. Square Sum is <= Threshold. So incrementing max side length to 3====


 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
  public int maxSideLength(int[][] mat, int threshold) {
    int maxRow = mat.length;
    int maxCol = mat[0].length;
    int[][] preSums = new int[maxRow + 1][maxCol + 1];
    int max = 0;

    buildPresums(mat, maxRow, maxCol, preSums);
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
    	// For that row already max length reached.   
        if (row - max < 0 || col - max < 0) continue;
        int topMaxSquarePresum = preSums[row - max][col + 1];
        int leftMaxSquarePresum = preSums[row + 1][col - max];
        int diagonalMaxSquarePresum = preSums[row - max][col - max];
        int currentPresum = preSums[row + 1][col + 1];

        if (currentPresum - leftMaxSquarePresum - topMaxSquarePresum + diagonalMaxSquarePresum
            <= threshold) {
          max += 1;
        }
      }
    }
    return max;
  }

  private void buildPresums(int[][] mat, int maxRow, int maxCol, int[][] preSums) {
    for (int i = 0; i < maxRow; i++) {
      for (int j = 0; j < maxCol; j++) {
        int leftPresum = preSums[i + 1][j];
        int topPresum = preSums[i][j + 1];
        int diagonalPreSum = preSums[i][j];
        int source = mat[i][j];
        int currentPresum = source + leftPresum + topPresum - diagonalPreSum;

        preSums[i + 1][j + 1] = currentPresum;
      }
    }
  }
}
