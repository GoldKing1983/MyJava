package com.interview.leetcode.facebook.medium;

/*
https://leetcode.com/problems/find-peak-element/

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Note:
 * 1) At left end and right end values are -INF.
 * 2) Because of above property, there will be a answer at all time.
 * Ex:
 * 10, 20, 30 Ans: 2
 * 30, 20, 10 Ans: 0
 * [-2147483648] Ans: 0
 * [-1] Ans: 0
 *
 * =========Very very corner cases. There will be more than 1 answer========
 * [10,1,30,40,50,60,70,80,90]
 * 2 answer here : 0 or 8
 *=============
===================================================Solution Approach===================================================

1) Binary Search, goes finding a element at mid. If element not found, it decides going left side or right side.
2) Similarly. Find a mid element. Compare it with left side number and right side number.
2a) If middle number is greater than both side. Then it is answer.
2b) If middle number is greater than left Number. Go Right. Else Go Left.

Ex:[10,20,30,9]. Initially index goes at 1. currentNumber>previousNumber. So Go Right.
In this case there "might" be a mountain at left side. But it is not guaranteed. But right side mountain is guaranteed.


Ex: 10 20 30 40 50 60 70 80... middle number is 40.
With respect to 40 left side condition passed. So right side.
 *
 */
public class FindPeakElement {

  public int findPeakElement(int[] nums) {
    return binSearch(nums, nums.length - 1, 0, nums.length - 1);
  }

  private int binSearch(int[] nums, int n, int low, int high) {
    if (low > high) return 0;
    int mid = low + (high - low) / 2;
    int prevNumber = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
    int nextNumber = mid == n ? Integer.MIN_VALUE : nums[mid + 1];
    int currNumber = nums[mid];
    if (currNumber > prevNumber && currNumber > nextNumber) return mid;
    if (currNumber >= prevNumber) return binSearch(nums, n, mid + 1, high);
    return binSearch(nums, n, low, mid - 1);
  }
}
