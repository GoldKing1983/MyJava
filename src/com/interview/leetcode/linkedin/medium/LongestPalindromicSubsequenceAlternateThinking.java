package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/longest-palindromic-subsequence/description/
========================================================Requirement==============================================================
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Input: "bbbab"
Output: 4.  One possible longest palindromic subsequence is "bbbb".

Input:"cbbd"
Output: 2
=============================================Solution Approach===================================================================
1) Reverse the inputString and make it as patternString.
2) Do Longest Common SubSequence.
 */
public class LongestPalindromicSubsequenceAlternateThinking {

  public int longestPalindromeSubseq(String input) {
    if (input == null || input.isEmpty()) return 0;
    String pattern = new StringBuilder(input).reverse().toString();
    return longestCommonSubsequence(input, pattern);
  }

  public int longestCommonSubsequence(String input, String pattern) {
    int rowMax = input.length();
    int colMax = pattern.length();
    int[][] dp = new int[rowMax + 1][colMax + 1];
    for (int row = 1; row <= rowMax; row++) {
      for (int col = 1; col <= colMax; col++) {
        if (input.charAt(row - 1) == pattern.charAt(col - 1)) {
          dp[row][col] = dp[row - 1][col - 1] + 1;
        } else {
          dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
        }
      }
    }
    return dp[rowMax][colMax];
  }
}
