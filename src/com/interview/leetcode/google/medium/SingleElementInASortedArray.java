package com.interview.leetcode.google.medium;

/*
https://leetcode.com/problems/single-element-in-a-sorted-array/
https://www.youtube.com/watch?v=nMGL2vlyJk0

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: nums = [3,3,7,7,10,11,11]
Output: 10

================================================================Solution Approach================================================================
1) if "even" and "odd" location numbers are same. Then duplicate is on right side. Else duplicate is on left side
2) increment low or mid by 2 instead of 1.

 */
public class SingleElementInASortedArray {
  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) return nums[0];

    int len = nums.length;
    int low = 0;
    int high = len - 1;

    while (low <= high && low < len && high >= 0) {
      int mid = low + (high - low) / 2;

      if ((mid - 1 >= 0 && nums[mid - 1] == nums[mid])
          || (mid + 1 < len && nums[mid + 1] == nums[mid])) { // nums[mid] is not single
        int currLen = high - low; // actual length - 1
        if ((currLen / 2) % 2 == 0) {
          if (nums[mid - 1] == nums[mid]) {
            // The element is on the left hand side
            high = mid - 2; // Skip mid-1 and mid as we know they are not single
          } else {
            // The element is on the right hand side
            low = mid + 2;
          }
        } else {
          if (nums[mid - 1] == nums[mid]) {
            // The element is on the right hand side
            low = mid + 1; // Skip mid
          } else {
            // The element is on the left hand side
            high = mid - 1;
          }
        }
      } else return nums[mid];
    }

    return nums[low];
  }
}
