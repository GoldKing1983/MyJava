package com.interview.leetcode.linkedin.medium;

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
 */
public class MaximumLengthOfRepeatedSubarrayLongestCommonSubstring {

  /*
     0  1  2   3   2   1
  ======================
  0  0  0  0   0   0   0
  3||0  0  0   1   0   0
  2||0  0  1   0   2   0
  1||0  1  0   0   0   3
  4||0
  7||0
  */
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
