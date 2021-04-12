package com.interview.leetcode.topic.dp;

/*
https://leetcode.com/problems/maximal-square/

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Input:
	[["1","1"],
	 ["1","1"]]
Output: 4

================================================Solution Approach================================================
				x | y
				=====
				z | a
			if a==1 then a = Math.min(x,y,z) + 1
			else a=0(or leave as such)
			=====================Why Math.min....=====================
Ex1:
				0 1
				1 1
Ex2:
				1 0
				1 1
Ex3:
				1 1
				0 1
Ex4:
				1 1
				0 1
Ex5:
				1 1
				1 1
In Ex1, Ex2, Ex3, Ex4 it cannot form 2 at index 1,1
Only Ex5 can form 2 at index 1,1 and only if we follow approach... Math.min(x,y,z) + 1

Also we cannot add the direct answer like 4 for 2*2 matrix...
Because every-time when a new square formed or extended with existing, it goes by "2Square=4 3Square=9 4Square=16 5Sauare=25".

================================================Data Flow Analysis================================================
Input:
	[["1","1"],
	 ["1","1"]]
Output: 4

Initial DP Matrix. Filled 0thRow and 0thCol
[1, 1]
[1, 0]

Filling DP Matrix Position: 1,1
[1, 1]
[1, 2]

Ans: Multiply 2*2 = 4
=====================================================================================
Input:
	[["1","1","1"],
	 ["1","1","1"],
	 ["1","1","1"]]
Output: 9

Initial DP Matrix. Filled 0thRow and 0thCol
[1, 1, 1]
[1, 0, 0]
[1, 0, 0]

Filling DP Matrix Position: 1,1
[1, 1, 1]
[1, 2, 0]
[1, 0, 0]

Filling DP Matrix Position: 1,2
[1, 1, 1]
[1, 2, 2]
[1, 0, 0]

Filling DP Matrix Position: 2,1
[1, 1, 1]
[1, 2, 2]
[1, 2, 0]

Filling DP Matrix Position: 2,2
[1, 1, 1]
[1, 2, 2]
[1, 2, 3]
=====================================================================================
 */
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int maxRow = matrix.length;
    if (maxRow == 0) return 0;
    int maxCol = matrix[0].length;
    int[][] dp = new int[maxRow][maxCol];
    // Fill 0th Row of dp as same as input matrix.
    for (int i = 0; i < maxRow; i++) dp[i][0] = matrix[i][0] == '1' ? 1 : 0;

    // Fill 0th Col of dp as same as input matrix.
    for (int i = 0; i < maxCol; i++) dp[0][i] = matrix[0][i] == '1' ? 1 : 0;

    for (int i = 1; i < maxRow; i++) {
      for (int j = 1; j < maxCol; j++) {
        if (matrix[i][j] == '1')
          dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
      }
    }

    int maximalSquare = 0;
    for (int[] d : dp) for (int value : d) maximalSquare = Math.max(maximalSquare, value);

    return maximalSquare * maximalSquare;
  }
}
