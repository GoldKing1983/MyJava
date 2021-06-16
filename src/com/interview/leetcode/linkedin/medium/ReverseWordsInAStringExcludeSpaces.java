package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/reverse-words-in-a-string/description/
===========================================================Requirement===========================================================
1) Given an input string s, reverse the order of the words.
2) Input string may contain leading or trailing spaces. 
   However, your reversed string should not contain leading or trailing spaces.
3) You need to reduce multiple spaces between two words to a single space in the reversed string.

============================================================Example1=============================================================
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:
============================================================Example2=============================================================
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
========================================================Solution Approach========================================================
This problem is a challenging problem with lot of edge cases. Don't stress out. Break into multiple problem and tackle one by one

step 1: reverse the whole string Ex: str = "Hello World"... reversedStr = "dlroW olleH"
step 2: reverse each word. Ex: reversedStr = "dlroW olleH"... result = "World Hello"
step 3: clean up spaces
 */
public class ReverseWordsInAStringExcludeSpaces {

  public String reverseWords(String s) {
    if (s == null) return null;

    char[] a = s.toCharArray();
    int n = a.length;

    reverse(a, 0, n - 1); // step 1: reverse the whole string

    reverseWords(a, n); // step 2: reverse each word

    return cleanSpaces(a, n); // step 3: clean up spaces
  }

  void reverseWords(char[] a, int n) {
    int left = 0, right = 0;
    //                                     0123456        
    // ex: str= "Hello World" reversedStr="dlroW olleH"
    while (left < n) {
      while (right < left || right < n && a[right] != ' ') right++; // skip non spaces.. right=5

      reverse(a, left, right - 1); // reverse the word... firstTime reversedWord="World olleH"

      while (left < right || left < n && a[left] == ' ') left++; // skip spaces.. i=0 
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int left = 0, right = 0;

    //      0123456789        
    // ex: "  hello  test"
    while (right < n) {
      while (right < n && a[right] == ' ') right++; // skip spaces... j=2

      while (right < n && a[right] != ' ') a[left++] = a[right++]; // keep non spaces.. copy from h to o

      while (right < n && a[right] == ' ') right++; // skip spaces... j=9

      if (right < n) a[left++] = ' '; // keep only one space... seeing that next word exists. so add ' ' to result. 
    }

    return new String(a).substring(0, left);
  }

  // reverse a[] from a[i] to a[j]
  private void reverse(char[] a, int left, int right) {
    while (left < right) {
      char temp = a[left];
      a[left++] = a[right];
      a[right--] = temp;
    }
  }

}
