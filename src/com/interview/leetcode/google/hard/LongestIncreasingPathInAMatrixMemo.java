package com.interview.leetcode.google.hard;

/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 Requirement: Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
==============================================================================================================
Example 1:
Input: nums =
[[9,7,5],
 [2,4,6],
 [8,3,0]]
Output: 4
Explanation: The longest increasing path is [0, 3, 4, 7, 9].

Recursion going to start for point: 9
[1, 0, 0]
[0, 0, 0]
[0, 0, 0]

Recursion going to start for point: 7
Applying Memo for Point: 9 and the value is 1
[1, 2, 0]
[0, 0, 0]
[0, 0, 0]

Recursion going to start for point: 5
Applying Memo for Point: 7 and the value is 2
[1, 2, 3]
[0, 0, 1] ====================> Note for 5, 6 is filled forward <====================
[0, 0, 0]

Recursion going to start for point: 2
Applying Memo for Point: 9 and the value is 1
Applying Memo for Point: 7 and the value is 2
Applying Memo for Point: 6 and the value is 1
[1, 2, 3]
[4, 3, 1] ====================> Note for 2, 4 and 8 is filled forward <====================
[1, 0, 0]

Recursion going to start for point: 4
Applying Memo for Point: 4 and the value is 3
[1, 2, 3]
[4, 3, 1]
[1, 0, 0]

Recursion going to start for point: 6
Applying Memo for Point: 6 and the value is 1
[1, 2, 3]
[4, 3, 1]
[1, 0, 0]

Recursion going to start for point: 8
Applying Memo for Point: 8 and the value is 1
[1, 2, 3]
[4, 3, 1]
[1, 0, 0]

Recursion going to start for point: 3
Applying Memo for Point: 4 and the value is 3
Applying Memo for Point: 8 and the value is 1
[1, 2, 3]
[4, 3, 1]
[1, 4, 0]

Recursion going to start for point: 0
Applying Memo for Point: 6 and the value is 1
Applying Memo for Point: 3 and the value is 4
[1, 2, 3]
[4, 3, 1]
[1, 4, 5]

=======================================Solution Approach============================================================
1) Recurse in 4 direction for a point. If the left/right/up/down value is greater than current. Increment the length.
2) Decrement the length will also work. Because. 1,2,3,4 or 4,3,2,1 both yields size 4.
3) isVisited is not needed. Because cycle cannot form due to "number comparism".
WordLadder problem has similar DFS, but it needs isVisted. Because it is words.
4) For each point memoize the result, for next index to use.
5) ++memo needs to be applied after "for loop" only. Because "for a point" increment needs to be applied "only once".
Ex: for x, only x needs to be incremented. a,b,c,d might be already visited and might have values. So a,b,c,d cannot
be incremented.
					a
				 b	x  c
				 	d
====================================================================================================================
Time complexity  : O(m*n)
Space complexity : O(m*n)
====================================================================================================================
 */
public class LongestIncreasingPathInAMatrixMemo {
  int maxRow;
  int maxCol;
  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};
  int[][] memo;

  public int longestIncreasingPath(int[][] matrix) {
    int max = 0;
    maxRow = matrix.length;
    if (maxRow == 0) return 0;
    maxCol = matrix[0].length;
    memo = new int[maxRow][maxCol];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        int currentMax = dfs(matrix, i, j, 1);
        max = Math.max(max, currentMax);
      }
    }
    return max;
  }

  public int dfs(int[][] matrix, int row, int col, int len) {
    if (memo[row][col] > 0) return memo[row][col];
    for (int i = 0; i < 4; i++) {
      int x = row + dx[i];
      int y = col + dy[i];
      if (x >= 0 && x < maxRow && y >= 0 && y < maxCol && matrix[x][y] > matrix[row][col]) {
        int currentMax = dfs(matrix, x, y, len + 1);
        memo[row][col] = Math.max(currentMax, memo[row][col]);
      }
    }
    return ++memo[row][col]; // Note: mem[row][col]++ will fail.
  }
}
