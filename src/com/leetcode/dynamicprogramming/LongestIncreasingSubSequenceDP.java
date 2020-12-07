package com.leetcode.dynamicprogramming;

/*
https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Input:[5,8,7,1,9]
Output: [5,8,9] or [5,7,9] size is 3.

======================================================================================================

See https://leetcode.com/problems/longest-increasing-subsequence/solution/ "Approach 3: Dynamic Programming" video...

Time Complexity is O(n^2)...LongestIncreasingSubSequenceBinarySearch is better than this
 */
public class LongestIncreasingSubSequenceDP {

  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) return 0;

    int[] dp = new int[nums.length];
    dp[0] = 1;
    int longestIncreasingSubSequence = 1;
    for (int i = 1; i < dp.length; i++) {
      int currentLongestIncreasingSubSequence = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          currentLongestIncreasingSubSequence =
              Math.max(currentLongestIncreasingSubSequence, dp[j]);
        }
      }
      dp[i] = currentLongestIncreasingSubSequence + 1;
      longestIncreasingSubSequence = Math.max(longestIncreasingSubSequence, dp[i]);
    }
    return longestIncreasingSubSequence;
  }
}
