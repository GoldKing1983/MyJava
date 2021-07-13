package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/
===========================================================Requirement===========================================================
1) Given an array of n positiveIntegers and target
2) Find the minimalLength of a contiguousSubArray of which the sum ≥ s. If there isn't one, return 0 instead.
Constraint : Only positive number

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Input: s = 100, nums = [2,3,1,2,4,100]
Output: 1


===========================Solution Approach=============================================
1) Window expands till currentSum < target
2) Stop Expanding the window when currentSum >= target.
   Shrink starts.
3) At each shrink point get the minLength
 */
public class MinimumSizeSubarraySumSlidingWindow {
  public int minSubArrayLen(int target, int[] nums) {

    int currentSum = 0;
    int minLengthResultWindow = Integer.MAX_VALUE;

    for (int left = 0, right = 0; right < nums.length; right++) {
      currentSum += nums[right];

      if (currentSum < target) continue;

      while (true) { // currentSum >= target
        int currentResultWindow = right - left + 1;
        minLengthResultWindow = Math.min(minLengthResultWindow, currentResultWindow);
        currentSum -= nums[left];
        left++;
        if (currentSum < target) break;
      }
    }

    return minLengthResultWindow == Integer.MAX_VALUE ? 0 : minLengthResultWindow;
  }
}
