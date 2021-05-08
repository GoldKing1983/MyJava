package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/is-subsequence/
===========================================================Requirement===========================================================
Given a string s and a string t, check if s is subsequence of t.

Example 1:
s = "abc", t = "ahbgdc"
Return true.

Example 2:
s = "axc", t = "ahbgdc"
Return false.
========================================================Solution Approach========================================================
1) Simple Sliding Window
2) If leftChar == rightChar move left.
        ex: 
            abc
            xayabc.
            For above example logic still works, because we are moving left only.
            
3) if (left == s.length()) return true;

*/
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) return true;
    int left = 0;
    for (char rightChar : t.toCharArray()) {
      char leftChar = s.charAt(left);
      if (leftChar == rightChar) {
        left++;
        if (left == s.length()) return true;
      }
    }
    return false;
  }

  public boolean isSubsequenceUsingLongestCommonSubSequence(String a, String b) {

    int maxRow = a.length() + 1;
    int maxCol = b.length() + 1;
    if (maxRow == 1) return true;
    if (maxCol == 1) return false;
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
    return longestCommonSubSequence == a.length();
  }
}
