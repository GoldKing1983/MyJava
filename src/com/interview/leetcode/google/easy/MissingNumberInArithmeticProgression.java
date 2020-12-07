package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/missing-number-in-arithmetic-progression/
 *
 * Ex: for 3 number.
 *
 *   2nd-1st != 3rd-2nd then return  3rd+1st-2nd
 *
 */
public class MissingNumberInArithmeticProgression {
  public int missingNumber(int[] arr) {
    int arrSize = arr.length;
    for (int i = 2; i < arrSize; i++) {
      if (arr[i - 1] - arr[i - 2] != arr[i] - arr[i - 1]) {
        return arr[i] + arr[i - 2] - arr[i - 1];
      }
    }

    return 0;
  }
}
