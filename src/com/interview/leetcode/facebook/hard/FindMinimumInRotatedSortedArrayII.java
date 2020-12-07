package com.interview.leetcode.facebook.hard;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
============================================Requirement=======================================================================
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.
You may assume no duplicate exists in the array.

===================================================Solve Below 2 case==========================================================
[10,1,10,10,10] Output: 1
[10,10,10,1,10] Output: 1

Trick is taking upper bound for compare and decrementing high.
 */
public class FindMinimumInRotatedSortedArrayII {

  public int findMin(int[] nums) {
    return binSearch(nums, 0, nums.length - 1);
  }

  private int binSearch(int[] nums, int low, int high) {
    if (low >= high) return nums[low]; // nums[low]..nums[high] both will work
    int mid = low + (high - low) / 2;
    if (nums[mid] > nums[high]) return binSearch(nums, mid + 1, high);
    else if (nums[mid] < nums[high]) return binSearch(nums, low, mid);
    else return binSearch(nums, low, high - 1);
  }
}
