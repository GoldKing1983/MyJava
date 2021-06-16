package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/find-the-duplicate-number/

https://leetcode.com/problems/find-the-duplicate-number/discuss/191309/Fast-slow-pointers-w-explanation-of-why-there-must-be-one-cycle

=================================================Solution Approach - Not Optimal=================================================
1) Using set to track duplicate. Space Complexity: O(n)
2) Take a number and compare with all remaining number for duplicate. Time Complexity : O(n^2).
3) Using Sort.O(n^2).
  a) If I sort the data, input data will be from "1 to N" for index "0 to N-1".
      Ex: input [ 2, 3, 3, 1 ]. Sorted data will be [1,2,3,3].  Index 3 should be having data 4.
  b) Compare previous and current data. return if duplicate.
========================================================Solution Approach========================================================
0) Solution using Hair and Tortoise or slow and fast pointers.
1) Same problem as LinkedListCycleii. List find if there is cycle and return cycle point
2) See picture "FindTheDuplicateNumber.png", how this problem is related to LinkedListCycleii.
In the picture cycle happens between 1,6,5.... slow and fast can stay in either of 1 or 5 or 6.
3) We need output as 1. So run second loop to get output 1.

Note: we are slow and fast pointers by child and not by parent. 
      Ex: 1 --> 2.. 1 is parent, 2 is child... 

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
