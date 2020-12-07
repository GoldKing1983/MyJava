package com.interview.leetcode.google.easy;

/*

https://leetcode.com/problems/remove-element/
=================================================Requirement===========================================================
Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Given nums = [3,2,2,3], val = 3,
Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length.

Given nums = [0,1,2,2,3,0,4,2], val = 2,
Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
Note that the order of those five elements can be arbitrary.
It doesn't matter what values are set beyond the returned length.

============================================Solution Approach==========================================================
1) if currentValue equals to the previousValue, skip writing element.
2) Else copy currentElement to write location
 */
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int write = 0;
    for (int read = 0; read < nums.length; read++) {
      if (nums[read] == val) {
        // Skip Writing. Don't do anything
      } else {
        nums[write] = nums[read];
        write++;
      }
    }
    return write;
  }
}
