package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

1) Find which side (Left or right side or both the side) is sorted.
2) If Both side is sorted then go in both direction
3) If any one side is sorted.
4) Check target lies in the sorted side. If yes go towards that side or go opposite.

 */
public class SearchInRotatedSortedArrayWithDuplicates {
  public boolean search(int[] nums, int target) {
    return binSearch(nums, target, 0, nums.length - 1);
  }

  public boolean binSearch(int[] nums, int target, int low, int high) {
    if (low > high) return false;

    int mid = low + ((high - low) / 2);

    if (nums[mid] == target) return true;

    else if (nums[low] <= nums[mid] && nums[high] >= nums[mid]) { // Both the sides are sorted 
      //Ex1: {2,7,2,2,2,2,2} //Ex2: {2,2,2,2,2,7,2}. Here it will be almost O(n)
      return binSearch(nums, target, low, mid - 1) || binSearch(nums, target, mid + 1, high);
    } else if (nums[low] <= nums[mid]) { // Left Side Sorted.
      if (target >= nums[low] && target <= nums[mid]) {// Check target lies in left side
        return binSearch(nums, target, low, mid - 1);
      } else {
        return binSearch(nums, target, mid + 1, high);
      }
    } else { // Right Side Sorted  
      if (target >= nums[mid] && target <= nums[high]) {// Check target lies in right side
        return binSearch(nums, target, mid + 1, high);
      } else {
        return binSearch(nums, target, low, mid - 1);
      }
    }


  }
}
