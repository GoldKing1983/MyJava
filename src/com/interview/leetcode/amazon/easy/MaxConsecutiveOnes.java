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
  public int findMaxConsecutiveOnesLookFor1(int[] nums) {
    int maxConsecutiveOnes = 0;
    int consecutiveOnes = 0;
    for (int num : nums) {
      if (num == 1) {
        consecutiveOnes++;
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnes);
      } else consecutiveOnes = 0;
    }
    return maxConsecutiveOnes;
  }

  public int findMaxConsecutiveOnesLookFor0(int[] nums) {
    int consecutiveOnes = 0;
    int maxConsecutiveOnes = 0;
    for (int num : nums) {
      if (num == 0) {
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnes);
        consecutiveOnes = 0;
      } else consecutiveOnes++;
    }
    return Math.max(maxConsecutiveOnes, consecutiveOnes);
  }

  // Without If Else Code
  public int findMaxConsecutiveOnesWithoutIf(int[] nums) {
    int maxSum = 0, sum = 0;
    for (int num : nums) {
      sum *= num; // If current is 0. sum changes to 0. If current is 1, sum still stays the same
      sum += num;
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }
}
