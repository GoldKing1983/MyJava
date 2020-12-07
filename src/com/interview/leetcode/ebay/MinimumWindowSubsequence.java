package com.interview.leetcode.ebay;

/*
https://leetcode.com/problems/minimum-window-subsequence/

1) Given strings inputStr and patternStr, find the minimum (contiguous) substring.
2) If there is no such window in inputStr that covers all characters in patternStr, return the empty string "".
3) If there are multiple such minimum-length windows, return the one with the left-most starting index.

Input:  S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: "bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.

=============================================Solution Approach - Brilliant Solution=============================================
We can conduct two steps by using two pointers for this problem:
Step1. Traverse from leftToRight make sure all characters in "patternStr" are matched.
Step2. Once a window is found. Traverse from rightToLeft to get the "minimalWindow".

We can traverse from left to right, find a possible candidate until reach the first ending character of patternStr

Example1: for the string inputStr = "abbdez", and patternStr = "bde",
we get the firstWindow. i.e. "bbde",
then traverse back from current "e" to find if we have smaller combination of "bde".

======================================================================================================================
 *
 */
public class MinimumWindowSubsequence {

  public String minWindow(String inputStr, String patternStr) {
    char[] input = inputStr.toCharArray(), pattern = patternStr.toCharArray();
    int inputIndex = 0, patternIndex = 0, inputLen = input.length, patternLen = pattern.length;
    int start = -1;
    while (inputIndex < input.length) {
      // Step1. Traverse from leftToRight make sure all characters in "patternStr" are matched.
      if (input[inputIndex] == pattern[patternIndex]) {
        patternIndex++;
        if (patternIndex == patternLen) { // Found a window of solution
          int end = inputIndex + 1;
          // Step2. Once a window is found. Traverse from rightToLeft to get the "minimalWindow".
          while (--patternIndex >= 0) {
            while (input[inputIndex--] != pattern[patternIndex]) ;
          }

          ++inputIndex;
          ++patternIndex;
          // record the current smallest candidate
          if (end - inputIndex < inputLen) {
            inputLen = end - inputIndex;
            start = inputIndex;
          }
        }
      }
      ++inputIndex;
    }
    return start == -1 ? "" : inputStr.substring(start, start + inputLen);
  }
}
