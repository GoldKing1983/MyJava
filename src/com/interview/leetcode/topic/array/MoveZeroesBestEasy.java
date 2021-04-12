package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/move-zeroes/
Similar problem : https://www.educative.io/courses/coderust-hacking-the-coding-interview/k58JJ
=============================================================Requirement=========================================================
1) Move all the 0's to the end of array.
2) All the non-zero elements must retain their original order.
==========================================================Solution Approach======================================================
Concept : Think of solution as magnetFromLeftSide pulling all non-zeroes.

1) Initially, Move the "writePtr" to stays at data "0". 
Ex: [1 2 3 0 4 5]
Because I don't need to do any process before zero. 

2) Now write stays in zero. read= write+1;

Ex: [1 2 3 0 0 4]
3) If i consider above example. write=3 and read=4 

4) On seeing zero I don't need to anything. just move read.
So write=3 and read=5

5) Once read sees nonZero. Move nonZero to zero. Update currentCol to zero. Move both read and write.

=====================================Data Flow Analysis=================================================================
Input:  [0,1,0,2,3]
Output: [1,2,3,0,0]

=============================================================================
 */
public class MoveZeroesBestEasy {
  public void moveZeroes(int[] nums) {

    int n = nums.length;
    int write = 0;
    // Move write to first zero point.
    while (write < n && nums[write] != 0) write++;

    int read = write + 1;

    while (read < n) {
      if (nums[read] != 0) {
        nums[write] = nums[read];
        nums[read] = 0;
        write++;
      }
    }
    read++;

  }
}
