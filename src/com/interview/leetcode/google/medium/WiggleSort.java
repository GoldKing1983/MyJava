package com.interview.leetcode.google.medium;

/*

Requirement : nums[0]<=nums[1]>=nums[2]
===========================================Solution Approach===========================================
1) For element at index 0 and 1 we compare nums[0]<nums[1]
if nums[0]<nums[1], element in order. continue. Else swap nums[0] and nums[1]

2) For element at index 1 and 2 we compare nums[1]>nums[2]
if nums[1]>nums[2], element in order. continue. Else swap nums[1] and nums[2]

3) So for 2 elements loop runs 1 time. elements at i and i+1.

4) So one time compare less and one time we compare more.



 */
public class WiggleSort {
  public void wiggleSort(int[] nums) {
    if (nums.length == 0) {
      return;
    }

    boolean compareLess = true;
    for (int i = 0; i < nums.length - 1; i++) {
      if (compareLess) {
        compareLess = false;
        if (nums[i] < nums[i + 1]) continue;
        swap(nums, i);
      } else {
        compareLess = true;
        if (nums[i] > nums[i + 1]) continue;
        swap(nums, i);
      }
    }
  }

  private void swap(int nums[], int i) {
    int temp = nums[i];
    nums[i] = nums[i + 1];
    nums[i + 1] = temp;
  }
}
