package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/shuffle-string/

Given a string s and an integer array indices of the same length.
The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

Return the shuffled string.
==============================================================Example1- Added spaces in input for easier comparism===============
input   = "a r t",
indices = [1,0,2]
Output: "rat"
==============================================================Example2- Added spaces in input for easier comparism===============
input   = "a b c",
indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in same position.
==============================================================Solution Approach==================================================
1) On seeing the inputString, we see 0th character in inputString needs to go to indices[0].
								     1st character in inputString needs to go to indices[1].
2) Create a char[] result array and move it.
  */

public class ShuffleStringBest {

  public String restoreString(String input, int[] indices) {
    int n = input.length();
    char[] result = new char[n];
    for (int i = 0; i < n; i++) {
      result[indices[i]] = input.charAt(i); // result[1] = a, result[0] = r, result[2] = t
    }
    return new String(result);
  }
}
