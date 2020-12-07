package com.interview.leetcode.facebook.easy;

/*

https://leetcode.com/problems/longest-continuous-increasing-subsequence/
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Input : [1,3,3,5,4,7] Output: 2
Input: [1,3,5,4,7] Output: 3
The longest continuous increasing subsequence is [1,3,5], its length is 3. [1,3,5,7] is not considered
Input: [2,2,2,2,2] Output: 1
 */
public class LongestContinuousIncreasingSubsequence { // LCIS
  public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 0) return 0;
    int currentLongest = 1;
    int longestResult = currentLongest;
    for (int left = 0, right = 1; right < nums.length; left++, right++) {
      if (nums[right] > nums[left]) {
        currentLongest++;
        longestResult = Math.max(longestResult, currentLongest);
      } else {
        currentLongest = 1;
        left = right - 1;
      }
    }
    return longestResult;
  }
}
