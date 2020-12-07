package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/

Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.
A majority element is an element that appears more than N/2 times in an array of length N.

Input: nums = [2,4,5,5,5,5,5,6,6], target = 5 Output: true
The value 5 appears 5 times and the length of the array is 9. Thus, 5 is a majority element because 5 > 9/2 is true.

Input: nums = [10,100,101,101], target = 101 Output: false
The value 101 appears 2 times and the length of the array is 4. Thus, 101 is not a majority element because 2 > 4/2 is false.

=======================================================Solution Approach=======================================================
1) Get the first occurrence of the target in the array by binary-search.
2) Verify if plusNBy2Index is also target.

 */
public class CheckIfANumberIsMajorityElementInASortedArray {
  public boolean isMajorityElement(int[] nums, int target) {
    int firstIndex = binSearch(nums, target, 0, nums.length - 1);
    int plusNBy2Index = firstIndex + nums.length / 2;

    if (plusNBy2Index >= nums.length) return false;

    return nums[firstIndex] == target && nums[plusNBy2Index] == target;
  }

  private int binSearch(int[] nums, int target, int low, int high) {
    if (low > high) return low;
    int mid = low + (high - low) / 2;
    if (target == nums[mid]) return binSearch(nums, target, low, mid - 1);
    if (target > nums[mid]) return binSearch(nums, target, mid + 1, high);
    return binSearch(nums, target, low, mid - 1);
  }
}
