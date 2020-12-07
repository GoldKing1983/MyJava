package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/maximum-product-subarray/description/

===============================================Solution Approach=================================================
1) Capture max from leftToRight.
2) Capture max from rightToLeft.
 */
public class MaximumProductSubarrayBest {

  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;

    int currentMax = 1;
    for (int i = 0; i < nums.length; i++) {
      currentMax = currentMax * nums[i];
      max = Math.max(currentMax, max);
      if (currentMax == 0) {
        currentMax = 1;
      }
    }

    currentMax = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      currentMax = currentMax * nums[i];
      max = Math.max(currentMax, max);
      if (currentMax == 0) {
        currentMax = 1;
      }
    }

    return max;
  }
}
