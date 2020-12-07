package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/max-consecutive-ones/

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

 */
public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
        max = Math.max(max, count);
      } else count = 0;
    }
    return max;
  }

  // Without If Else Code
  public int findMaxConsecutiveOnesWithoutIf(int[] nums) {
    int maxSum = 0, sum = 0;
    for (int n : nums) {
      sum *= n; // If current is 0. sum changes to 0. If current is 1, sum still stays the same
      sum += n;
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }
}
