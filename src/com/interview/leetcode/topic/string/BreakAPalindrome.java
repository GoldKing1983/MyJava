package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/break-a-palindrome/
===========================================================Requirement===========================================================
1) Given a palindromic string as input.
2) replace any one char such that input is not anymore palindrome.
3) replacement should be "lexicographically smallest"
    input : aba
    output: abb... abb is wrong

    input : xyx
    output: ayx...
========================================================Solution Approach========================================================
If I split the word by 2, there are only 2 states available:

1) If the character is not an 'a,' change it to be an 'a'.
2) if all the characters are 'a' change the last letter to be a 'b' to break the palindrome,
and since it's the last letter, increasing it to a 'b' will minimize the increase in lexicographical order.
=================================================================================================================================
 */
public class BreakAPalindrome {
  public String breakPalindrome(String palindrome) {
    if (palindrome.length() <= 1) return "";
    char[] arr = palindrome.toCharArray();
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
      if (arr[i] != 'a') { // if not a then change it to be lexographically smallest
        arr[i] = 'a';
        return String.valueOf(arr);
      }
    }
    // if we reach here, there are ONLY 'a' in palindrome string, so we should change the last
    // character from a to b
    arr[n - 1] = 'b';
    return String.valueOf(arr);
  }
}
