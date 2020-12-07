package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/longest-palindromic-substring/
In above we need to return the string itself. Here we are returning length.

=============================================Solution Approach========================================================================
1) If the element at the beginning and the end are the same, we make a recursive call to check,
 if the remaining substring is also a palindrome. If so, the substring is a palindrome from beginning to the end.
2) We will skip either the element from the beginning or the end to make two recursive
calls for the remaining substring. The length of LPS would be the maximum of these two recursive calls.
=======================================================================================================================================
 */
public class LongestPalindromicSubStringRecursionMemo {

  public int longestPalindrome(String st) {
    return findLPSLengthRecursive(st, 0, st.length() - 1, new Integer[st.length()][st.length()]);
  }

  private int findLPSLengthRecursive(String st, int left, int right, Integer[][] cache) {
    if (left > right) return 0;

    // every string with one character is a odd palindrome
    if (left == right) return 1;
    if (cache[left][right] != null) return cache[left][right];
    // case 1: elements at the beginning and the end are the same
    if (st.charAt(left) == st.charAt(right)) {
      int remainingLength = right - left - 1;
      // check if the remaining string is also a palindrome
      if (remainingLength == findLPSLengthRecursive(st, left + 1, right - 1, cache))
        return remainingLength + 2;
    }

    // case 2: skip one character either from the beginning or the end
    int c1 = findLPSLengthRecursive(st, left + 1, right, cache);
    int c2 = findLPSLengthRecursive(st, left, right - 1, cache);
    cache[left][right] = Math.max(c1, c2);
    return cache[left][right];
  }
}
