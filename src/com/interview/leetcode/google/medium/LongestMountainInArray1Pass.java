package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/longest-mountain-in-array/
 */
public class LongestMountainInArray1Pass {
  public int longestMountain(int[] A) {
    int max = 0, i = 1, N = A.length;

    while (i < N) {
      int up = 0, down = 0;
      // skip equal values
      while (i < N && A[i - 1] == A[i]) i++;

      // count up
      while (i < N && A[i - 1] < A[i]) {
        i++;
        up++;
      }

      // count down
      while (i < N && A[i - 1] > A[i]) {
        i++;
        down++;
      }

      if (up > 0 && down > 0) max = Math.max(max, up + down + 1);


    }
    return max;
  }
}
