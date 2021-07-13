package com.interview.leetcode.topic.recursion;

/*
https://leetcode.com/problems/longest-palindromic-subsequence/description/
===========================================================Requirement===========================================================
1) Given a string s
2) find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
============================================================Example1=============================================================
Input: "bbbab"
Output: 4.  One possible longest palindromic subsequence is "bbbb".
============================================================Example2=============================================================
Input:"cbbd"
Output: 2
==============================================Solution Approach - O(n^2)================================================================
Here DP is filled from rightToLeft. In wordBreakDP DP is filled from leftToRight
1) Create 2d dp matrix.
2) From last ---- compare from leftToRight.
Ex: "bxyb"
Compare Index: 2,3(y,b)
Compare Index: 1,2(x,y), Compare Index: 1,3(x,b)
Compare Index: 0,1(b,x), Compare Index: 0,2(b,y), Compare Index: 0,3(b,b)

					x | y
					=====
					z | a

	If equal.... a = 2+ Pick diagonal(x).
	Else    .... a = Math.max(z,y)
=======================================================================================================================================
Input: "bxyb" Output:3

Comparing Index: 2 3
DP Array at End of Loop: [0, 0, 1, 1]

Comparing Index: 1 2
Comparing Index: 1 3
DP Array at End of Loop: [0, 1, 1, 1]

Comparing Index: 0 1
Comparing Index: 0 2
Comparing Index: 0 3
Left Char and Right Char Matched Updated DP: [1, 1, 1, 3]
DP Array at End of Loop: [1, 1, 1, 3]

[0, 0, 0, 1]
[0, 0, 1, 1]
[0, 1, 1, 1]
[1, 1, 1, 3]
=======================================================================================================================================

 */
public class LongestPalindromicSubsequenceDP {

  public int longestPalindromeSubseq(String str) {
    int maxRow = str.length(), maxCol = maxRow;
    int[][] dp = new int[maxRow][maxCol];
    int currentCol = maxCol - 1;
    for (int row = 0; row < maxRow; row++) {
      dp[row][currentCol] = 1; // Ex: "a". matrix of size 1,1 created and it was set to 1 here.
      for (int col = currentCol + 1; col < maxCol; col++) {
        if (str.charAt(currentCol) == str.charAt(col)) {
          dp[row][col] = 2 + dp[row - 1][col - 1]; // Pick diagonal
        } else {
          int currentRowPreviousColValue = dp[row][col - 1];
          int previousRowCurrentColValue = dp[row - 1][col];
          dp[row][col] = Math.max(currentRowPreviousColValue, previousRowCurrentColValue);
        }
      }
      currentCol--;
    }
    return dp[maxRow - 1][maxCol - 1];
  }
}
