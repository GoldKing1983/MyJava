package com.leetcode.interview;

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
1) Take currentSum as 0. Because it works for negative and positive number. If all numbers are negative. Still it works.
2) Take maxSum as Integer.MIN_VALUE. Because if all negative. Then logic needs to pick bigNegative.
2) Add currentNumber with prefixSum.
3) Update maxSum if prefixSum>maxSum.
4) Reset currentSum to 0, if it is less than 0.

Ex1: [1, -1]  Ans: 1
Ex2: [-1 -2 -3] Ans: -1
Ex3: [2, -1, 3] Ans: 4

 */
public class MaximumSubArraySum {

  public int maxSubArray(int[] nums) {

    int prefixSum = 0;
    // If i put maxSum to 0. Then it will not work for case {-1,-2,-3} . i.e all negative value.
    int maxSum = Integer.MIN_VALUE;
    for (int currentNumber : nums) {

      prefixSum = prefixSum + currentNumber;

      if (prefixSum > maxSum) maxSum = prefixSum; // Adjust maxSum to currentPrefixSum

      if (prefixSum < 0) prefixSum = 0; // Set the sum to zero in case value went negative
    }
    return maxSum;
  }
}
