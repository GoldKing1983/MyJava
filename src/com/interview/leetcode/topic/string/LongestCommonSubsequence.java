package com.interview.leetcode.topic.string;

/*
https://binarysearch.com/problems/Longest-Common-Subsequence

Input
a = "abcvc"
b = "bv"
Output : 2
            0   b   v 
        0   0   0   0 
        a   0   0   0
        b   0   1   0
        c   0   1   1
        v   0   1   2

 */
public class LongestCommonSubsequence {
  public int solve(String a, String b) {
    int maxRow = a.length() + 1;
    int maxCol = b.length() + 1;
    if (maxRow == 1 || maxCol == 1) return 0;
    int[][] dp = new int[maxRow][maxCol];
    int longestCommonSubSequence = 0;
    for (int row = 1; row < maxRow; row++) {
      char rowValue = a.charAt(row - 1);
      for (int col = 1; col < maxCol; col++) {
        char colValue = b.charAt(col - 1);
        if (rowValue == colValue) {
          dp[row][col] = dp[row - 1][col - 1] + 1;
        } else {
          dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
        }
        longestCommonSubSequence = Math.max(longestCommonSubSequence, dp[row][col]);

      }
    }

    return longestCommonSubSequence;
  }
}
