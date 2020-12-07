package com.interview.leetcode.google.medium;
/*

https://leetcode.com/problems/palindromic-substrings/

Same logic as LongestPalindromicSubstring. But here count for each palindrome

*/

public class PalindromicSubstrings {

  int count = 1;

  public int countSubstrings(String s) {
    if (s.length() == 0) return 0;
    for (int i = 0; i < s.length() - 1; i++) {
      checkPalindrome(s, i, i); // To check the palindrome of odd length palindromic sub-string
      checkPalindrome(s, i, i + 1); // To check the palindrome of even length palindromic sub-string
    }
    return count;
  }

  private void checkPalindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { // Check for the palindrome string
      count++; // Increment the count if palindrome substring found
      left--; // To trace string in left direction
      right++; // To trace string in right direction
    }
  }


}
