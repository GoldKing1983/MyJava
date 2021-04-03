package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/implement-strstr/
===========================================================Requirement===========================================================
1) Implement indexOf functionality from Java API.
2) We can think of it as firstIndexOf.

Input: inputString = "hello", searchString = "ll"
Output: 2

Input: inputString = "aaaaa", searchString = "bba"
Output: -1
========================================================Solution Approach========================================================
1) Pretty Straight forward comparism from leftToRight.
=========================================================Time Complexity=========================================================
O(m*n) --> m represents inputStringN and n represents searchStringN 
 */
public class ImplementStrStr {

  public int strStr(String inputString, String searchString) {
    int inputStringN = inputString.length(), searchStringN = searchString.length();

    if (searchStringN == 0) return 0; // Ex: inputString="hello", searchString=""

    if (inputStringN == 0) return -1; // Ex: inputString="", searchString="hello"


    for (int i = 0; i < inputStringN; i++) {

      int j = i, k = 0; // Assign i's index to j. Because i needs to stay idle and we can move j.
      if (j + searchStringN > inputStringN) break; // searchString is larger than inputString

      while (k < searchStringN) {
        char inputStringChar = inputString.charAt(j);
        char searchStringChar = searchString.charAt(k);
        if (inputStringChar != searchStringChar) break;// go for next sequence
        j++;
        k++;
      }
      if (k == searchStringN) return i; // searchString matched inputString... return index of inputString
    }

    return -1;
  }
}
