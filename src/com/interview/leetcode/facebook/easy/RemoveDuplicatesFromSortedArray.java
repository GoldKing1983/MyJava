package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.
============================================Solution Approach=========================================================
1) if currentValue equals to the previousValue, skip writing element.
2) Else copy currentElement to write location
*/
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    int write = 1; // 0th element cannot be duplicate, so start from 1.
    for (int read = 1; read < nums.length; read++) {
      int currentValue = nums[read];
      int previousValue = nums[read - 1];
      if (currentValue == previousValue) {
        // Skip Writing. Don't do anything
      } else {
        nums[write] = nums[read];
        write++;
      }
    }
    return write;
  }
}
