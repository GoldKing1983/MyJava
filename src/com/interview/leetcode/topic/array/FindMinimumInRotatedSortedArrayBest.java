package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Similar to "InorderSuccessorInBSTBest"
============================================Requirement=======================================================================
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

"You may assume no duplicate exists in the array."

Input: [3,4,5,1,2]
Output: 1

Input: [4,5,6,7,0,1,2]
Output: 0
============================================Solution Approach==================================================================

============================================Possible Cases==================================================================

Since the array is sorted and rotated. At any point, if I split the array, there can be "3 cases".
					Case1:	   Ex: [3,4,5,1,2]. Initially mid stays at index2. Left  side sorted. Right side not sorted.
					Case2:	   Ex: [4,5,1,2,3]. Initially mid stays at index2. Right side sorted. Left side not sorted.
					Case3:	   Ex: [1,2,3,4,5]. Initially mid stays at index2. Both side sorted.
		==========Below case are not possible= or possible in descending sorted rotated array=========try rotate and see
					CaseWrong1:	   Ex: [5,4,3,2,1].
					CaseWrong2:    Ex: [2,1,5,4,3]

==========================================================Deep Thinking==========================================================
Finding a pattern, Why I cannot use nums[low] to compare 
    // Ex1: [1,2,3,4,5]...Ex2: [3,4,5,1,2].. Here result is1. 
    //For Ex1 I need to move high and for Ex2 I need to move low.
    // But both cases are covered in below code which is wrong..  
    if (nums[mid] > nums[low]) return binSearch(nums, low, mid);


 */
public class FindMinimumInRotatedSortedArrayBest {
  public int findMin(int[] nums) {
    return binSearch(nums, 0, nums.length - 1);
  }

  private int binSearch(int[] nums, int low, int high) {
    if (low == high) return nums[low];

    int mid = low + (high - low) / 2;
    // Ex: [1,2,3,4,5]... move high...
    if (nums[mid] < nums[high]) return binSearch(nums, low, mid);

    // Ex1: [3,4,5,1,2]...move low...
    return binSearch(nums, mid + 1, high);

  }
}
