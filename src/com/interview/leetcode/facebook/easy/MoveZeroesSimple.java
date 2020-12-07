package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/move-zeroes/
Similar problem : https://www.educative.io/courses/coderust-hacking-the-coding-interview/k58JJ
=============================================================Requirement=========================================================
1) Move all the 0's to the end of array.
2) All the non-zero elements must retain their original order.
==========================================================Solution Approach======================================================
1) Move the "writePtr" to stays at data "0"
2) If "readPtr" is non-zero. then move data from "non-zero" to zero. Update nonZero at readLocation to zero.
=================================================================================================================================
 */
public class MoveZeroesSimple {
  public void moveZeroes(int[] nums) {

    int n = nums.length;
    int write = 0;
    // Move write to first zero point.
    while (write < n && nums[write] != 0) write++;
    for (int read = write + 1; read < n; read++) {
      if (nums[read] != 0) {
        nums[write] = nums[read];
        write++;
      }
    }
    while (write < n) nums[write++] = 0;
  }
}
