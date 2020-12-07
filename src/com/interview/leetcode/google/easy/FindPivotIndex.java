package com.interview.leetcode.google.easy;

import java.util.Arrays;

/*

https://leetcode.com/problems/find-pivot-index/

Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is
equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes,
you should return the left-most pivot index.

Example 1:

Input:
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

=====Result at index0=====
[-1,-1,-1,0,1,1]
Output = 0

=====Result at lastIndex=====
[-1,-1,0,1,1,100]
Output = 5

 */
public class FindPivotIndex {
  public int pivotIndex(int[] nums) {
    int prefixSum = Arrays.stream(nums).parallel().sum();
    int currentSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int pivotNumber = nums[i];
      int pivotNegatedSum = prefixSum - pivotNumber - currentSum;
      if (currentSum == pivotNegatedSum) return i;
      currentSum += nums[i];
    }
    return -1;
  }
}
