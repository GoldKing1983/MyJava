package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/maximum-subarray/description/
============================================================Requirement================================================
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
============================================================Solution Approach================================================
1) Keep add currentNum to currentSum from leftToRight. Update maxSum from currentSum.
2) If currentSum<0 reset. Because if answer goes negative. We want to keep minimum.

Ex1: [1, -1]  Ans: 1
Ex2: [-1 -2 -3] Ans: -1
Ex3: [2, -1, 3] Ans: 4

 */
public class MaximumSubArraySum {

  public int maxSubArray(int[] nums) {

    int currentSum = 0;
    // If i put maxSum to 0. Then it will not work for case {-1,-2,-3} . i.e all negative value.
    int maxSum = Integer.MIN_VALUE;
    for (int num : nums) {
      currentSum += num;
      maxSum = Math.max(currentSum, maxSum); // Update maxSum from currentSum.
      if (currentSum < 0) currentSum = 0; // Reset
    }
    return maxSum;

  }
}
