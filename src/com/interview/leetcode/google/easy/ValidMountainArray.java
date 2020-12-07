package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/valid-mountain-array/

https://www.youtube.com/watch?v=WWysBX-N2Ak

Requirement: If there exists only 1 mountain from 0 to high then low. Return True. Else False.

Input: [0,10,20,10] Output: True
Input: [0,20,10] Output: True
Input: [0,20,30] Output: False
Input: [0,20,20,10] Output: False
 */
public class ValidMountainArray {
  public boolean validMountainArray(int[] arr) {
    int i = 0;
    for (; i < arr.length - 1; i++) {
      int curr = arr[i];
      int next = arr[i + 1];
      if (curr < next) continue;
      break;
    }
    // Ex: [2,1] didn't increased.  [1,2,3,4] Increased all the way to end.
    if (i == 0 || i == arr.length - 1) return false;
    for (; i < arr.length - 1; i++) {
      int curr = arr[i];
      int next = arr[i + 1];
      if (curr > next) continue;
      return false;
    }
    return true;
  }
}
