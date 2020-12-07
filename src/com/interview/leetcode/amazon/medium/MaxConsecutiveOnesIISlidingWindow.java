package com.interview.leetcode.amazon.medium;

/*
https://leetcode.com/problems/max-consecutive-ones-ii/

Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.

==========================================Solution Approach - Sliding Window==========================================
1) Start from index0. Create/Extend the window till noZero or oneZero.
		1a) left stays at index0.
		1b) right moves till secondZeroFound.
		1c) measure windowSize at each step and update maxWindow.
2) When the secondZero comes, Shrink the window till firstZero.
		2a) left moves to location after zero. right stays at the same index.
		2b) measure windowSize at each step and update maxWindow.
3) Do step2 till indexN-1

 */
public class MaxConsecutiveOnesIISlidingWindow {
  public int findMaxConsecutiveOnes(int[] nums) {
    boolean zeroFound = false;
    int maxConsecutiveOnes = 0;
    for (int left = 0, right = 0; right < nums.length; right++) {
      if (nums[right] == 0) {
        if (zeroFound) { // Time To Shrink
          // Go Left Till 0.
          while (true) {
            if (nums[left] == 0) break;
            left++;
          }
          left++; // Move left after zero
        } else {
          zeroFound = true;
        }
      }
      int currentWindow = right - left + 1;
      maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentWindow);
    }
    return maxConsecutiveOnes;
  }
}
