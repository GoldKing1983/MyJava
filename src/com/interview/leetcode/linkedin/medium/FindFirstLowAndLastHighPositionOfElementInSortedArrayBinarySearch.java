package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

For the search key, if duplicate is found on the input array. Get the index of first duplicate.

  Input : arr[] = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10}
  x = 5
  Output : First Occurrence = 4
  Output : Last Occurrence = 11

========================================================Solution Approach===================================================
1) Find the lowIndex of target.
2) If the lowIndex is valid-target. Find the highIndex.
=========Note the corner cases==========
1) If the element is not found. Still there will be some index returned.
Ex1: [5,7,7,8,8,10] target=6  --> lowIndex=1. So check for element at index == target.
Ex1: [5,7,7,8,8,10] target=4  --> lowIndex=0. So check for element at index == target.
2) Low can cross the array size.
Ex: [2,2] target=3 --> lowIndex=2

 */
public class FindFirstLowAndLastHighPositionOfElementInSortedArrayBinarySearch {
  public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) return new int[] {-1, -1};
    int n = nums.length;
    int lowerIndex = binarySearchGetLower(nums, target, 0, n - 1);
    if (lowerIndex == n || nums[lowerIndex] != target) return new int[] {-1, -1};
    int higherIndex = binarySearchGetHigher(nums, target, 0, n - 1);
    return new int[] {lowerIndex, higherIndex};
  }

  public int binarySearchGetLower(int[] nums, int target, int low, int high) {
    if (low > high) return low;
    int mid = low + (high - low) / 2;
    if (nums[mid] >= target) return binarySearchGetLower(nums, target, low, mid - 1);
    return binarySearchGetLower(nums, target, mid + 1, high);
  }

  public int binarySearchGetHigher(int[] nums, int target, int low, int high) {
    if (low > high) return high;
    int mid = low + (high - low) / 2;
    if (nums[mid] <= target) return binarySearchGetHigher(nums, target, mid + 1, high);
    return binarySearchGetHigher(nums, target, low, mid - 1);
  }
}
