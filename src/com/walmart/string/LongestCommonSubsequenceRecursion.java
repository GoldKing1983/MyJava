package com.walmart.string;

/*
https://leetcode.com/problems/longest-common-subsequence/
https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/B8Pq4ZnBN0N

Input: text1 = "abcde",
	   text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Input: text1 = "abc",
	   text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Input: text1 = "abc",
       text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
==========================================Solution Approach Dp - O(n^2)=================================================

=========================================================================================================================
"algorithm"
"altruistic"
output: 5
*/
public class LongestCommonSubsequenceRecursion {

  public int longestCommonSubsequence(String input, String pattern) {
    return longestCommonSubsequence(input.toCharArray(), pattern.toCharArray(), 0, 0);
  }

  public static int longestCommonSubsequence(
      char[] input, char[] pattern, int inputIndex, int patternIndex) {
    if (inputIndex == input.length || patternIndex == pattern.length) return 0;
    if (input[inputIndex] == pattern[patternIndex])
      return 1 + longestCommonSubsequence(input, pattern, inputIndex + 1, patternIndex + 1);

    int left = longestCommonSubsequence(input, pattern, inputIndex, patternIndex + 1);
    int right = longestCommonSubsequence(input, pattern, inputIndex + 1, patternIndex);
    return Math.max(left, right);
  }
}
