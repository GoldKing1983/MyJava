package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/find-the-duplicate-number/
===================================================Requirement===================================================
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.


Input: [1,3,4,2,2]
Output: 2

Input: [3,1,3,4,2]
Output: 3

===================================================Solution Approach===================================================
1) Change index of number to negative.
2) If it is negative already then it is duplicate.

Note:
1) Here the Constraint is "You must not modify the array (assume the array is read only)".
2) For above constraint I can Change all negative to positive in another loop.
3) If the interviewer is not happy. Then solution is "FindTheDuplicateNumberSlowFastApproach"
===================================================DataFlow Analysis===================================================
Input: [1,3,4,2,2] Output: 2

Processing 1 : [1, -3, 4, 2, 2]
Processing 3 : [1, -3, 4, -2, 2]
Processing 4 : [1, -3, 4, -2, -2]
Processing 2 : [1, -3, -4, -2, -2]
Processing 2 : Index2 is already negative. So Returning index2 as output.


 */
public class FindTheDuplicateNumberNegativeApproach {
  public int findDuplicate(int[] nums) {
    int ansIndex = 0;
    for (int num : nums) {

      if (num < 0) num = -num;

      if (nums[num] < 0) {
        ansIndex = num;
        break;
      }
      nums[num] = -nums[num]; // Change index of number to negative.
    }

    return ansIndex;
  }
}
