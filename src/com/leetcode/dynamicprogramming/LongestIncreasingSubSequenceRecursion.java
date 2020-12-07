package com.leetcode.dynamicprogramming;

/*
 *  https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

===========================================Solution Approach: O(2^n)=================================================================================
1) A basic brute-force solution could be to try all the subsequences of the given number sequence.
2) We can process one number at a time, so we have two options at any step:
3) If the current number is greater than the previous number that we included, we can increment our count
and make a recursive call for the remaining array.
4) Else, We can skip the current number to make a recursive call for the remaining array.
5) The length of the longest increasing subsequence will be the maximum number returned by the
two recurse calls from the above two options.
================================================================================================================================================
 */
public class LongestIncreasingSubSequenceRecursion {

  public int lengthOfLIS(int[] nums) {
    return lengthofLIS(nums, Integer.MIN_VALUE, 0);
  }

  private int lengthofLIS(int[] nums, int prevNumber, int index) {
    if (index == nums.length) return 0;
    int included = 0, currentNumber = nums[index];
    if (currentNumber > prevNumber) included = 1 + lengthofLIS(nums, currentNumber, index + 1);
    int notIncluded = lengthofLIS(nums, prevNumber, index + 1);
    return Math.max(included, notIncluded);
  }
}
