package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/kth-missing-positive-number/
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
=======================================Logical Thinking=====================================================
1) Randomly Choose any index.
2) Comparing ============(nums[random]-1) == random===========  gives number of missing element at left of random.
Like QuickSelect Pivot. This is the key to find kth element by moving left or right.
=======================================Solution Approach=====================================================
Similar to problem MissingElementInSortedArrayBinarySearch. See the detailed analysis there.
*/
public class KthMissingPositiveNumber {
  public int findKthPositive(int[] nums, int k) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      int missingGapSize = nums[mid] - 1 - mid;

      if (missingGapSize == k) { // Go Left
        high = mid - 1;
      } else if (missingGapSize > k) { // Go Left
        high = mid - 1;
      } else { // (missingSize<k) // Go Right
        low = mid + 1;
      }
    }
    return high + 1 + k;
  }
}
