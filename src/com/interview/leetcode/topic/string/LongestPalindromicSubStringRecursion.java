package com.interview.leetcode.topic.string;

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
public class LongestPalindromicSubStringRecursion {

  public int longestPalindrome(String st) {
    return findLPSLengthRecursive(st, 0, st.length() - 1);
  }

  private int findLPSLengthRecursive(String st, int left, int right) {
    if (left > right) return 0;

    // every string with one character is a odd palindrome
    if (left == right) return 1;

    // case 1: elements at the beginning and the end are the same
    if (st.charAt(left) == st.charAt(right)) {
      int remainingLength = right - left - 1;
      // check if the remaining string is also a palindrome
      if (remainingLength == findLPSLengthRecursive(st, left + 1, right - 1))
        return remainingLength + 2;
    }

    // case 2: skip one character either from the beginning or the end
    int c1 = findLPSLengthRecursive(st, left + 1, right);
    int c2 = findLPSLengthRecursive(st, left, right - 1);
    return Math.max(c1, c2);
  }

  public static void main(String[] args) {
    LongestPalindromicSubStringRecursion l = new LongestPalindromicSubStringRecursion();
    System.out.println(l.longestPalindrome("abca"));
    System.out.println(l.longestPalindrome("babad")); // 3
    System.out.println(l.longestPalindrome("cbbd")); // 2
    System.out.println(l.longestPalindrome("abacab")); // 5
    System.out.println(l.longestPalindrome("abacab 4567891")); // 5
    System.out.println(l.longestPalindrome("a bacab 4567891")); // 7
  }
}
