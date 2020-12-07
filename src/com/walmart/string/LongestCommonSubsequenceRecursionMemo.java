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
=============================================Initial Thinking====================================================================
Similar to "GroupSum6" and not "GroupSum".
 		i.e GroupSum ==> Go in 2path(left&right) vs GroupSum ==> Go in 1path If 6 Else Go in 2path(left&right)
==========================================Solution Approach Dp - O(n^2)=================================================
See Also LongestPalindromicSubsequenceRecursion

1) compare inputString and patternString characters from 0th index.
2) If both matches. increment both index. Add +1. recurse.
3) Else left = increment inputIndex recur, right = increment patternIndex recur. return Math.max(left, right);
=========================================================================================================================
"algorithm"
"altruistic"
output: 5
*/
public class LongestCommonSubsequenceRecursionMemo {

  public int longestCommonSubsequence(String input, String pattern) {

    int inputLength = input.length(), patternLength = pattern.length();
    return longestCommonSubsequence(
        input.toCharArray(), pattern.toCharArray(), 0, 0, new Integer[inputLength][patternLength]);
  }

  public static int longestCommonSubsequence(
      char[] input, char[] pattern, int inputIndex, int patternIndex, Integer[][] dp) {
    if (inputIndex == input.length || patternIndex == pattern.length) return 0;
    if (dp[inputIndex][patternIndex] != null) return dp[inputIndex][patternIndex];
    if (input[inputIndex] == pattern[patternIndex])
      return 1 + longestCommonSubsequence(input, pattern, inputIndex + 1, patternIndex + 1, dp);

    int left = longestCommonSubsequence(input, pattern, inputIndex, patternIndex + 1, dp);
    int right = longestCommonSubsequence(input, pattern, inputIndex + 1, patternIndex, dp);
    dp[inputIndex][patternIndex] = Math.max(left, right);
    return dp[inputIndex][patternIndex];
  }
}
