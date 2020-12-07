package com.interview.leetcode.linkedin.medium;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
Similar to FindMinimumInRotatedSortedArray
https://www.educative.io/collection/page/5668639101419520/5671464854355968/5141325911425024

1) Since the array is sorted. At any point, if I split the array, one side is sorted and other is not sorted.
2) Find the sorted side by condition (a[low]<=a[mid])--->if true, then  left is sorted, else right side is sorted.
3) Check if target lies between the sorted side, If yes go towards that side or go opposite.

Since the array is sorted and rotated. At any point, if I split the array, there can be "3 cases".
					Case1:	   Ex: [3,4,5,1,2]. Initially mid stays at index2. Left  side sorted. Right side not sorted.
					Case2:	   Ex: [4,5,1,2,3]. Initially mid stays at index2. Right side sorted. Left side not sorted.
					Case3:	   Ex: [1,2,3,4,5]. Initially mid stays at index2. Both side sorted.
		==========Below case are not possible= or possbile in descending sorted rotated array=========try rotate and see
					CaseWrong1:	   Ex: [5,4,3,2,1].
					CaseWrong2:    Ex: [2,1,5,4,3]


=============================================Reason for <= in all compare========================================================
1) When we code, we might think there are no duplicates in input. Then why it should "<=".
2) Reason is, in many case. low and mid will be same or high and mid will be same. 
 
There are so many corner cases... This also covers both side sorted cases. Just mug it... Don't waste time.
Example1: [10,20] target=20.

Here low=0, high=1. mid=0.  

*/
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    return binSearch(nums, target, 0, nums.length - 1);
  }

  public int binSearch(int[] nums, int target, int low, int high) {
    if (low > high) return -1;
    int mid = low + ((high - low) / 2);
    if (nums[mid] == target) return mid;
    else if (nums[low] <= nums[mid]) { // Left Side Sorted.
      if (target >= nums[low] && target <= nums[mid]) { // Check target lies in left side
        return binSearch(nums, target, low, mid - 1); // Yes target lies in left side. Go Left
      }
      return binSearch(nums, target, mid + 1, high); // No target lies in right side. Go Right
    } else { // Right Side Sorted
      if (target >= nums[mid] && target <= nums[high]) { // Check target lies in right side
        return binSearch(nums, target, mid + 1, high);
      }
      return binSearch(nums, target, low, mid - 1);
    }
  }
}
