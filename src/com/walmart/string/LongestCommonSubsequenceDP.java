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
==========================================BruteForce : O(2^n))========================================================
1) Take all combination(continuous/discontinuous ) of input1 and input2.
Ex: a b c --> combination would be--> a,b,c,ab,bc,ac, abc
(Note: for Longest Common SubSequence "ac" will not come. Because it is discontinuous)
2) For every substring, verify it exists in input string Ex: a b d.
========================================================Solution Approach========================================================
				a || b
				======
				c || current

current = a+1 if matches, else Math.max(b,c)
=======================================================Data Flow Analysis========================================================
Input: word1 = "a", word2 = "a" Output=0
               0 a
               =======
          0 || 0 0
          a || 0 1
=======================================================Data Flow Analysis========================================================
Input: word1 = "a", word2 = "abc" Output=1
               0 a b c
               =======
          0 || 0 0 0 0
          a || 0 1 1 1
=======================================================Data Flow Analysis========================================================
Input: word1 = "abc", word2 = "ac" Output=2
               0 a c
               =====
          0 || 0 0 0
          a || 0 1 1
          b || 0 1 1
          c || 0 1 2
=======================================================Data Flow Analysis========================================================
Input: word1 = "ace", word2 = "abcde" Output=3

               0  a  c  e
          ===============
          0 || 0  0  0  0
          a || 0  1  1  1
          b || 0  1  1  1
          c || 0  1  2  2
          d || 0  1  2  2
          e || 0  1  2  3

*/
public class LongestCommonSubsequenceDP {

  // Time Complexity : O(n^2)
  public int longestCommonSubsequence(String input, String pattern) {
    int maxRow = input.length() + 1, maxCol = pattern.length() + 1, longestCommonSubSequence = 0;

    int[][] dp = new int[maxRow][maxCol];

    for (int row = 1; row < maxRow; row++) {
      char rowValue = input.charAt(row - 1);

      for (int col = 1; col < maxCol; col++) {
        char colValue = pattern.charAt(col - 1);

        if (rowValue == colValue) {
          dp[row][col] = dp[row - 1][col - 1] + 1;
        } else {
          dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
        }

        longestCommonSubSequence = Math.max(longestCommonSubSequence, dp[row][col]);
      }
    }

    return longestCommonSubSequence;
  }
}
