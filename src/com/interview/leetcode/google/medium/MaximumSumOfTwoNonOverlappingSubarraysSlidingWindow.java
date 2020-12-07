package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays,
which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)



Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
Output: 20 Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.

Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
Output: 29 Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.

Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
Output: 31 Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] with length 3.


==========================================================Solution Approach=========================================
sliding windows 2 passes: l -> r then r -> l

Code for the below diagram

ex: [0, 6, 5, 2, 9, 1], L = 1, R = 2 Ans: 20

        start with index L + R
        -> [(0), (6, 5), 2, 9, 1] -> maxL = 0, R = 11 -> res = 11
        -> [0, (6), (5, 2), 9, 1] -> maxL = 6, R = 7  -> res = 13
        -> [0, 6, (5), (2, 9), 1] -> maxL = 6, R = 11 -> res = 17
        -> [0, 6, 5, (2), (9, 1)] -> maxL = 6, R = 10 -> res = 17 (17 > 16)
        -> first pass: 17

        second pass: go the opposite way or flip L & R;
        -> [(0, 6), (5), 2, 9, 1] -> maxL = 6 , R = 5  -> res = 11
        -> [0, (6, 5), (2), 9, 1] -> maxL = 11, R = 2  -> res = 13
        -> [0, 6, (5, 2), (9), 1] -> maxL = 11, R = 9  -> res = 20
        -> [0, 6, 5, (2, 9), (1)] -> maxL = 11, R = 1  -> res = 20 (20>12)
        -> second pass: 20
============================================================================================================================
*/

public class MaximumSumOfTwoNonOverlappingSubarraysSlidingWindow {
  public int maxSumTwoNoOverlap(int[] A, int L, int R) {
    return Math.max(maxSumLR(A, L, R), maxSumLR(A, R, L));
  }

  // helper funtion sliding window left to right
  private int maxSumLR(int[] A, int L, int R) {
    // start with L + R
    int i = 0;
    int sumL = 0, sumR = 0;
    // start with i = L + R
    while (i < L) sumL += A[i++];
    while (i < L + R) sumR += A[i++];

    int maxL = sumL, res = maxL + sumR;
    for (; i < A.length; i++) {
      // update the windows
      sumR += A[i] - A[i - R];
      sumL += A[i - R] - A[i - L - R];
      maxL = Math.max(maxL, sumL);
      res = Math.max(res, maxL + sumR);
    }
    return res;
  }
}
