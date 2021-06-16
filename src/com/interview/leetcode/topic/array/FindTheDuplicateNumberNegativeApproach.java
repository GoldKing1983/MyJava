package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/find-the-duplicate-number/
===========================================================Requirement===========================================================
1) Given an array of nums from 1 and n-1
2) find the duplicate one.
3) Assume duplicate exists always.

Input: [1,1,2] ==> here n=3 so max number is 2 only
Output: 1

Input: [1,2,2] ==> here n=3 so max number is 2 only
Output: 2

Input: [1,3,4,2,2] ==> here n=5 so max number is 4 only
Output: 2

Input: [3,1,3,4,2] ==> here n=5 so max number is 4 only
Output: 3
=========================================================InvalidExample==========================================================
Input: [1,1,3] .. all element must present with 1 duplicate. Also 3 is not allowed
Input: [1,2,3] .. there must be 1 duplicate. Also 3 is not allowed
========================================================Solution Approach========================================================
1) Change index of number to negative.
2) If it is negative already then it is duplicate.

Note:
1) Here the Constraint is "You must not modify the array (assume the array is read only)".
2) For above constraint I can Change all negative to positive in another loop.
3) If the interviewer is not happy. Then solution is "FindTheDuplicateNumberSlowFastApproach"
=======================================================Data Flow Analysis========================================================
Input: [1,3,4,2,2] Output: 2

Processing 1 : [1, -3, 4, 2, 2]
Processing 3 : [1, -3, 4, -2, 2]
Processing 4 : [1, -3, 4, -2, -2]
Processing 2 : [1, -3, -4, -2, -2]
Processing 2 : Index2 is already negative. So Returning index2 as output.


 */
public class FindTheDuplicateNumberNegativeApproach {
  public int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // Ex:[2,1,2]
      // 1 --> 2.. 1 is parent, 2 is child... 
      // If 1 or parent is negative, change it to positive, don't change array.
      // Get Child. If 2 or child is negative. return 2 itself stating 2 is duplicate

      int parent = Math.abs(nums[i]);// nums[i] < 0 ? -nums[i] : nums[i];
      int child = nums[parent];
      if (child < 0) return parent;
      nums[parent] = -child; // Change value of child to negative.
    }
    return -1;

  }
}
