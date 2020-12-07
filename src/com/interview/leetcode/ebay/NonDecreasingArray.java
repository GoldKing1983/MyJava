package com.interview.leetcode.ebay;

/*
https://leetcode.com/problems/non-decreasing-array/
==========================================================Requirement============================================================
Given an array nums with n integers, your task is to check if it could become increasing always by modifying at most 1 element.

Input: nums = [4,2,3]
Output: true
Explanation: decrease 4 to 1 to get a non-decreasing array.

Input: nums = [4,5,3]
Output: true
Explanation: increase 3 to 6 to get a non-decreasing array.

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

Input: nums = [3,4,2,3]
Output: false
Explanation: At (4,2) decrement is happening. I can change either 4 or 2 to any number.
But whatever the number I change for 2 and 4. Still it cannot be increasing order always.
Ex: Change 4 with 1,2,3 - [3,1,2,3] - [3,2,2,3] - [3,3,2,3]
Ex: Change 2 with 1,3,4 - [3,4,1,3] - [3,4,3,3] - [3,4,4,3]

========================================================Solution Approach========================================================
1) fromLeftToRight make sure it is ascending  order even after changing at-most 1 time.
2) fromRightToLeft make sure it is descending order even after changing at-most 1 time.
3) If any one is true. Return true;
Note: we are not comparing current and next. Keep one result(max or min). Compare current result all the time.
=======================================================Data Flow Analysis=======================================================
Input: nums = [4,2,3]
verifyLeftToRightAscending: false. verifyRightToLeftDescending: true. Answer: true

Input: nums = [4,5,3]
verifyLeftToRightAscending:  true. verifyRightToLeftDescending: false. Answer: true

Input: nums = [4,2,1]
verifyLeftToRightAscending: false. verifyRightToLeftDescending: false. Answer: false

 */
public class NonDecreasingArray {

  public boolean checkPossibility(int[] nums) {
    return verifyLeftToRightAscending(nums) || verifyRightToLeftDescending(nums);
  }

  private boolean verifyLeftToRightAscending(int[] nums) {
    boolean modifiedOnce = false;
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] >= max) max = nums[i];
      else {
        if (modifiedOnce) return false;
        modifiedOnce = true;
      }
    }
    return true;
  }

  private boolean verifyRightToLeftDescending(int[] nums) {
    boolean modifiedOnce = false;
    int n = nums.length;
    int min = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] <= min) min = nums[i];
      else {
        if (modifiedOnce) return false;
        modifiedOnce = true;
      }
    }
    return true;
  }
}
