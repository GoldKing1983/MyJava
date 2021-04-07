package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/move-zeroes/
Similar problem : https://www.educative.io/courses/coderust-hacking-the-coding-interview/k58JJ
==========================================Requirement===================================================================
1) Move all the 0's to the end of array.
2) All the non-zero elements must retain their original order.
======================================================Solution Approach=================================================
1) Think of solution as magnetFromLeftSide pulling all non-zeroes.
2) Instead of searching for 0. Search for non-zero and move it to the writePtr.
The reason being 0 can be over-written with non-zero values. And finally 0 can be filled.
3) readPtr moves and looks for non-zeroes. if non-zero found override data at writePtr.
4) No swap is needed, move value from readPtr to writePtr.

Step1: Move data from "readPtr to writePtr", if it is non-zero.
Step2: Fill zeroes at end.
=====================================Worst Case Analysis================================================================
If all numbers are unique. There will be "n" copy operations.
=====================================Data Flow Analysis=================================================================
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

write: 0 read: 0 [0, 1, 0, 3, 12]
write: 0 read: 1 [1, 1, 0, 3, 12]
write: 1 read: 2 [1, 1, 0, 3, 12]
write: 1 read: 3 [1, 3, 0, 3, 12]
write: 2 read: 4 [1, 3, 12, 3, 12]
write: 3 read: 5 [1, 3, 12, 3, 12]

Fill Zeroes from write to array length
[1, 3, 12, 0, 12]
[1, 3, 12, 0, 0]
=============================================================================

 */
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int write = 0;
    // Step1: Move data from "readPtr to writePtr" if it is non-zero
    for (int read = 0; read < nums.length; read++) {
      if (nums[read] != 0) {
        nums[write] = nums[read];
        write++;
      }
    }
    // Step2: Fill zeroes at end
    while (write < nums.length) {
      nums[write] = 0;
      write++;
    }
  }
}
