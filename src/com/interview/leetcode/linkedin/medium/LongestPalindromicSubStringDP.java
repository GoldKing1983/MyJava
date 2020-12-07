package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/longest-palindromic-substring/
In above we need to return the string itself. Here we are returning length.


=======================Solution Approach - Time Complexity: O(n^2)========================================================================
1) At every step, we will try all of its substrings. So for every right and left in the given string,
we need to check the following thing:

2) If the element at the left matches the element at the right, we will further check,
if the remaining substring (from left+1 to right-1) is a substring too.
=======================================================================================================================================
 */
public class LongestPalindromicSubStringDP {

  public int findLPSLength(String str) {
    // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a palindrome
    boolean[][] dp = new boolean[str.length()][str.length()];

    // every string with one character is a palindrome
    for (int i = 0; i < str.length(); i++) dp[i][i] = true;

    int maxLength = 1;
    for (int left = str.length() - 1; left >= 0; left--) {
      for (int right = left + 1; right < str.length(); right++) {
        if (str.charAt(left) == str.charAt(right)) {
          // if it's a two character string or if the remaining string is a palindrome too
          if (right - left == 1 || dp[left + 1][right - 1]) {
            dp[left][right] = true;
            maxLength = Math.max(maxLength, right - left + 1);
          }
        }
      }
    }

    return maxLength;
  }
}
