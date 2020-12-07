package com.interview.leetcode.facebook.medium;

import com.leetcode.interview.MaximumSubArraySum;

/*
https://leetcode.com/problems/maximum-sum-circular-subarray/

Ex: for 5 numbers
calculate maxSum from index 0 to 4.
calculate maxSum from index 1 to 0.
calculate maxSum from index 2 to 1.
calculate maxSum from index 3 to 2.
calculate maxSum from index 4 to 3.
whichever max is answer

Time Complexity : O(n^2) . Solution Throws TimeLimitException

 */
public class MaximumSumCircularSubarrayBruteForce {
  MaximumSubArraySum maximumSubArraySum = new MaximumSubArraySum();

  public int maxSubarraySumCircular(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      // Create new circular array from source array
      int[] newNums = new int[nums.length];
      // Update data for new circular array
      for (int j = i, n = nums.length, k = 0; n > 0; k++, n--, j++) {
        if (j == nums.length) j = 0;
        newNums[k] = nums[j];
      }
      // Calculate maxSum
      max = Math.max(max, maximumSubArraySum.maxSubArray(newNums));
    }
    return max;
  }
}
