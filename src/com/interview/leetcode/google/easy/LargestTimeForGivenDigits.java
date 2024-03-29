package com.interview.leetcode.google.easy;

import java.util.Arrays;

public class LargestTimeForGivenDigits {
  public String largestTimeFromDigits(int[] A) {
    Arrays.sort(A);
    for (int i = 3; i >= 0; i--) {
      if (A[i] <= 2) {
        for (int j = 3; j >= 0; j--) {
          if ((A[i] != 2 || A[j] <= 3) && i != j) {
            for (int k = 3; k >= 0; k--) {
              if (A[k] <= 5 && i != k && j != k) {
                // 6 comes from 0+1+2+3 which are indexes of array so left index is calculated from
                // 6 - i,j,k
                return "" + A[i] + A[j] + ":" + A[k] + A[6 - i - j - k];
              }
            }
          }
        }
      }
    }
    return "";
  }
}
