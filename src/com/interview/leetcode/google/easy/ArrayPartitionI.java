package com.interview.leetcode.google.easy;

import java.util.Arrays;

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer,
say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

=============================================================Solution Approach================================================
1) On analyzing the requirement, each number has to be paired with next number.
2) Then only we can get Maximum sum of pair out of every pair minimum.
3) Sort the input.
4) Sum the elements. Ex:[1,2,3,4]--> sum 1,3
 */
public class ArrayPartitionI {
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 0; i < nums.length; i += 2) {
      sum += nums[i];
    }
    return sum;
  }
}
