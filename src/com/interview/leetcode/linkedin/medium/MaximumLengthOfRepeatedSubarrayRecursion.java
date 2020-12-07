package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

===========================================Requirement======================================================================
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3, 2, 1].
=============================================================================================================================
Ex1:
[1,2,3,0,1]
[1,2,3,4,1]

Output:3

 */
public class MaximumLengthOfRepeatedSubarrayRecursion {

  public int findLength(int[] A, int[] B) {
    return recur(0, 0, A, B, 0);
  }

  int recur(int aIndex, int bIndex, int[] A, int[] B, int matchingLCS) {
    if (A.length == aIndex || B.length == bIndex) return matchingLCS;
    if (A[aIndex] == B[bIndex]) {
      // Cannot return here. Then for Ex1, output will be1. i.e. Only last match will be returned
      matchingLCS = recur(aIndex + 1, bIndex + 1, A, B, matchingLCS + 1);
    }
    // Every time I need to reset the lcs to 0.
    int leftLCS = recur(aIndex + 1, bIndex, A, B, 0);
    int rightLCS = recur(aIndex, bIndex + 1, A, B, 0);
    return Integer.max(matchingLCS, Integer.max(leftLCS, rightLCS));
  }
}
