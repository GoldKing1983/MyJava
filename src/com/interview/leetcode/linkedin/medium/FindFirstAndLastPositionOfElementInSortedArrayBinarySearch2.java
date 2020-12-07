package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

 For the search key, if duplicate is found on the input array. Get the index of first duplicate and last duplicate.

 Input : arr[] = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9, 10}
 x = 5
 Output : First Occurrence = 4
 Output : Last Occurrence = 11

========================================================Solution Approach===================================================
1) When the element is found. Increment low and high in steps.
2) This approach will be slow, if the distance between mid and low/high is big.
Because it goes step by step, after finding target.
==========================================Data Flow Analysis==========================================
[5,6,6,6,7,7,8,8,8,8,8,8,8,8,8,10] target = 8
low mid high 0 7 15
low mid high 1 8 15
low mid high 2 8 15
low mid high 3 9 15
low mid high 4 9 15
low mid high 5 10 15
low mid high 6 10 15
low mid high 6 10 14
Found firstIndex and firstIndex of target

[1,2,2,2,2,2,2,2,2,2,3,3,3,4,5,6] target = 2
low mid high 0 7 15
low mid high 1 8 15
low mid high 1 7 14
low mid high 1 7 13
low mid high 1 6 12
low mid high 1 6 11
low mid high 1 5 10
low mid high 1 5 9
Found firstIndex and firstIndex of target

[2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2] target = 2
low mid high 0 7 15
Found firstIndex and firstIndex of target


*/
public class FindFirstAndLastPositionOfElementInSortedArrayBinarySearch2 {
  public int[] searchRange(int[] nums, int target) {
    return binarySearchGetHigherAndLower(nums, target, 0, nums.length - 1);
  }

  public int[] binarySearchGetHigherAndLower(int[] nums, int target, int low, int high) {
    if (low > high) return new int[] {-1, -1};
    int mid = low + (high - low) / 2;
    if (nums[mid] == target) { // Target Found. Finding first and last
      while (true) {
        if (nums[low] == nums[high]) {
          return new int[] {low, high};
        }
        if (nums[low] < target) low = low + 1;
        else high = high - 1;
      }

    } else if (nums[mid] < target) {
      return binarySearchGetHigherAndLower(nums, target, mid + 1, high);
    }
    return binarySearchGetHigherAndLower(nums, target, low, mid - 1);
  }
}
