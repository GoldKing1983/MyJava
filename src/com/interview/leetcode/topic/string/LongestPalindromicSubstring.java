package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/longest-palindromic-substring/description/
See image "PalindromicSubstrings.png"


1) Start from 0 th character. Call updatePalindrome with 
                                0,0 for odd palindrome 
                                0,1 for even palindrome
2) Keep call getPalindromeString from 0 to n-1 and cache maxWidth

Ex: aba
oddProcess = a, evenProcess = ab
oddProcess = b(This wins in getting longest), evenProcess = ba
loop runs 2 times. getPalindromeString called 4 times

Ex: abba
oddProcess = a, evenProcess = ab
oddProcess = b, evenProcess = bb(This wins in getting longest)
oddProcess = b, evenProcess = ba
loop runs 3 times. getPalindromeString called 6 times
================================================Time Complexity : O(n^2)================================================
 */
public class LongestPalindromicSubstring {



  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return "";
    int n = s.length();
    for (int i = 0; i < n - 1; i++) {
      updatePalindrome(s, n, i, i);// get longest palindrome with center of i
      updatePalindrome(s, n, i, i + 1); // get longest palindrome with center of i, i+1
    }
    return s.substring(resultLeft, resultRight + 1);
  }

  int maxLongest = 0;
  int resultLeft = 0;
  int resultRight = 0;

  //given 2 points left and right. expand as much as possible to find longest palindrome.
  private void updatePalindrome(String s, int n, int left, int right) {
    while (left >= 0 && right < n) {
      if (s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      } else break;
    }
    left++; // Ex: "a" . left=-1 and right=1. So increment left and decrement right by 1.  
    right--;
    int currentLongest = right - left + 1;
    if (currentLongest > maxLongest) {
      maxLongest = currentLongest;
      resultLeft = left;
      resultRight = right;
    }

  }
}
