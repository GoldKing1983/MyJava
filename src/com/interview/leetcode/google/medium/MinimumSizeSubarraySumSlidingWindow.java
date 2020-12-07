package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/

Given an array of n positive integers and a positive integer s, find the minimal length of a
contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
Constraint : Only positive number

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Input: s = 100, nums = [2,3,1,2,4,100]
Output: 1


===========================Solution Approach=============================================
1) Stop Expanding the window till curSum >= s.
2) Shrink. if curSum >= s.
3) At each shrink point get the minLength
 */
public class MinimumSizeSubarraySumSlidingWindow {
  public int minSubArrayLen(int s, int[] nums) {

    int curSum = 0;
    int minLen = Integer.MAX_VALUE;

    for (int left = 0, right = 0; right < nums.length; right++) {
      curSum += nums[right];
      while (curSum >= s) {
        minLen = Math.min(minLen, right - left + 1);
        curSum -= nums[left];
        left++;
      }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
