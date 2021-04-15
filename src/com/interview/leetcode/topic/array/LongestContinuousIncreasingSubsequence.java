package com.interview.leetcode.topic.array;

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
    if (nums == null || nums.length == 0) return 0;
    int maxIncreasingSequence = 1;
    int currentIncreasingSequence = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        currentIncreasingSequence++;
        maxIncreasingSequence = Math.max(maxIncreasingSequence, currentIncreasingSequence);
      } else {
        currentIncreasingSequence = 1;
      }
    }
    return maxIncreasingSequence;
  }
}
