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
    A is row
    B is col
    
        0   3   2   1   4   7
        0   0   0   0   0   0
     1  0   0   0   1   0   0   
     2  0   0   1   0   0   0
     3  0   1   0   0   0   0
     2  0   0   2   0   0   0
     1  0   0   0   3   0   0
      
     same = diagonal+1
     else = 0

 1) The first row and first column entries, filled directly by comparing 
 2) For rest of rows, If character matches, then pick value diagonally and add 1 to it. Else 0.
 				a ||
 				======
 				  || current (current = a+1 if matches, else 0)

 ====Logically if a column matches and next column don't matches. we put 0. Because it is discontinued.=======
 ====But in Longest Common Sub Sequence we pick previous value. Because if discontinued, we take previous answer=========

 */
public class MaximumLengthOfRepeatedSubarrayLongestCommonSubstring {

  public int findLength(int[] A, int[] B) {
    int maxRow = A.length + 1;
    int maxCol = B.length + 1;

    int[][] dp = new int[maxRow][maxCol];

    int maxLength = 0;
    for (int row = 1; row < maxRow; row++) { // 0th row ignored.. A is row. Keep the AthData idle per row.

      int aData = A[row - 1];

      for (int col = 1; col < maxCol; col++) { // 0th col ignored.. B is col. Run BthData for each of AthData

        int bData = B[col - 1];

        if (aData == bData) dp[row][col] = dp[row - 1][col - 1] + 1;

        maxLength = Math.max(maxLength, dp[row][col]);
      }
    }
    return maxLength;
  }
}
