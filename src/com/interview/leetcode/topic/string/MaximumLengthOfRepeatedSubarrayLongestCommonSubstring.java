package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

===========================================Requirement===========================================================================
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3, 2, 1].
=================================================================================================================================
  /*
     0  1  2   3   2   1
  ======================
  0  0  0  0   0   0   0
  3||0  0  0   1   0   0
  2||0  0  1   0   2   0
  1||0  1  0   0   0   3
  4||0
  7||0

 1) The first row and first column entries, says for 0 "search string" for "input string" output is 0.
 2) If character matches, then pick value diagonally and add 1 to it. Else 0.
 				a ||
 				======
 				  || current (current = a+1 if matches, else 0

 ====Logically if a column matches and next column don't matches. we put 0. Because it is discontinued.=======
 ====But in Longest Common Sub Sequence we pick previous value. Because if discontinued, we take previous answer=========

 */
public class MaximumLengthOfRepeatedSubarrayLongestCommonSubstring {
  public int findLength(int[] str1, int[] str2) {
    int[][] dp = new int[str1.length + 1][str2.length + 1];
    int result = 0;
    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
    return result;
  }
}
