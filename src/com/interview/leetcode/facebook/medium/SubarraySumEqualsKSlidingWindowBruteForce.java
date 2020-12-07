package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/
https://www.youtube.com/watch?v=xa_60srQAKo
==================================
Given an array of integers and an integer k, you need to find the total number of continuous subarrays
whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
====================BruteForce======O(n^2)======================================================================
1) Simple sliding window. start left from 0 and right=left.
2) Move right till n. Find all sums.
3) Reason why we go all the way end is at any point if a negative number found it can get a result.
4) If a result found. Increase resultCount.
5) Increase left by 1 and right=left. Do step2.
=======Note: below case is enough to cover all test case during interview===========================================
[0,0,0]
0
Output : 6(1+2+3)

With index0 - 0
0
0,0
0,0,0
With index1 - 0
0
0,0
With index2 - 0
0
================================================================================================================
[3,2,1]
3
Output : 2

 */
public class SubarraySumEqualsKSlidingWindowBruteForce {
  public int subarraySum(int[] nums, int sum) {
    int resultCount = 0;
    for (int left = 0; left < nums.length; left++) {
      int currentSum = 0;
      int right = left;
      while (right < nums.length) {
        currentSum += nums[right];
        if (currentSum == sum) resultCount++;
        right++;
      }
    }
    return resultCount;
  }
}
