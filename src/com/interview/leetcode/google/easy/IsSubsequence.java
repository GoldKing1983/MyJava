package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/is-subsequence/

Given a string s and a string t, check if s is subsequence of t.

Example 1:
s = "abc", t = "ahbgdc"
Return true.

Example 2:
s = "axc", t = "ahbgdc"
Return false.
================================================================================================
1) Simple Sliding Window
2) If leftChar == rightChar move left.
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
}
