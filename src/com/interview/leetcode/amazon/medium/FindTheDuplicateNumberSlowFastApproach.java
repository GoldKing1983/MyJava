package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/find-the-duplicate-number/

https://leetcode.com/problems/find-the-duplicate-number/discuss/191309/Fast-slow-pointers-w-explanation-of-why-there-must-be-one-cycle

Given an array where each integer is between 1 and n (inclusive)there is only one duplicate number,
find the duplicate one. The duplicate might be repeated more than once.

Input : [ 2, 3, 3, 1 ]
Output:3

Input : [2,1,3,4,1,6,7,8,9,1] ==> More than 1 duplicate example
Output:1


=====================Solution Approach - O(n^2)==============
1) If I sort the data, input data will be from "1 to N" for index "0 to N-1".
2) So one of the index is having wrong data.
Ex: input [ 2, 3, 3, 1 ]. Sorted data will be [1,2,3,3].  Index 3 should be having data 4.
3) One solution should be to sort data and check previous and current data.
4) But sorting takes O(n^2).
====================Solution Approach - O(n) - List find if there is cycle and return cycle point====================
Same problem as LinkedListCycleii.
See picture "FindTheDuplicateNumber.png", how this problem is related to LinkedListCycleii.
In the picture cycle happens between 1,6,5.... slow and fast can stay in either of 1 or 5 or 6.
We need output as 1. So run second loop to get output 1.

 */
public class FindTheDuplicateNumberSlowFastApproach {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int slow = nums[0], fast = nums[0];
    // Step1: verify cycle exists
    while (true) {
      slow = nums[slow];
      fast = nums[fast]; // fast = nums[nums[fast]];
      fast = nums[fast];
      if (slow == fast) break;
    }
    // Step2: It is guaranteed that cycle exists always. So get cycle point.
    fast = nums[0];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }
}
