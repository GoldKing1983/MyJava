package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/running-sum-of-1d-array/

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

 

Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].



 */
public class RunningSumOf1dArray {
  public int[] runningSum(int[] nums) {
    int n = nums.length;

    for (int i = 1; i < n; i++) {
      nums[i] += nums[i - 1];
    }

    return nums;
  }
}
