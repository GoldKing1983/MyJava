package com.interview.leetcode.topic.binarysearch;

import java.util.Arrays;

/*
https://leetcode.com/problems/split-array-largest-sum/
========================================================================================================================================
Requirement: Given an array of numbers, partition them into "optimal-continuous" groups and return highest partition in the group.
Input: nums = [7,2,5,10,8]  m = 2
Output:18

Explanation:
There are four ways to split nums into two subarrays. The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
========================================================================================================================================

=================Difference between DivideChocolate and this============
1) Here low=max because we want largestSum and there low = min because we want smallestSum.
2) returns low and there low-1.
3) total > sumRequired in here. there total >= sumRequired
=========================================Solution Approach============================================
Refer DivideChocolate for detailed analysis..
This problem can be compared to MissingElementInSortedArrayBinarySearch,FindKthSmallestPairDistance, DivideChocolate
======================================================================================================================================
*/
public class SplitArrayLargestSum {
  public int splitArray(int[] arr, int partitionSize) {
    int low = Arrays.stream(arr).max().getAsInt();
    int high = Arrays.stream(arr).sum();
    return binSearch(arr, low, high, partitionSize);
  }

  private int binSearch(int[] arr, int low, int high, int partitionSize) {
    if (low > high) return low;
    int mid = low + (high - low) / 2;
    if (canCutArrayIntoKPartitions(arr, mid, partitionSize))
      return binSearch(arr, mid + 1, high, partitionSize);
    return binSearch(arr, low, mid - 1, partitionSize);
  }

  public boolean canCutArrayIntoKPartitions(int[] arr, int sumRequired, int requiredPartitionSize) {
    int currentPartitionSize = 0;
    int total = 0;
    for (int i = 0; i < arr.length; i++) {
      total += arr[i];
      if (total > sumRequired) {
        currentPartitionSize++;
        total = arr[i];
      }
      if (currentPartitionSize == requiredPartitionSize) return true;
    }
    return false;
  }
}
