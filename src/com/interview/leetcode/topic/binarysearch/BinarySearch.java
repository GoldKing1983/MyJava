package com.interview.leetcode.topic.binarysearch;

/*

https://leetcode.com/problems/binary-search/
===========================================================Requirement===========================================================
To avoid overflow of maximum positive int value (2^31 - 1). use "int mid = low + ((high - low) / 2);"
================
Iterative solution has same O(logn) runtime complexity as the recursive solution but has better memory complexity.
Memory Complexity for Iterative : Constant, O(1).
Memory Complexity for Recursion : O(logn) as recursion consume memory on the stack.
=================================================================================================================================
*/
public class BinarySearch {

  public int search(int[] nums, int target) {
    return binSearch(nums, target, 0, nums.length - 1);
  }

  private int binSearch(int[] nums, int target, int low, int high) {
    if (low > high) return -1;
    int mid = low + ((high - low) / 2);
    if (nums[mid] == target) return mid;
    if (nums[mid] < target) return binSearch(nums, target, mid + 1, high);
    return binSearch(nums, target, low, mid - 1);
  }
}
