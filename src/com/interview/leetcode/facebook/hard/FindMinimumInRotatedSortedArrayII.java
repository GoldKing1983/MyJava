package com.interview.leetcode.facebook.hard;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

hard problem... don't waste time.

============================================Requirement=======================================================================
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.
You may assume duplicate can exists in the array.

======================================================Invalid Cases==========================================================
CaseWrong : [5,4,3,2,1] Output: 1-----> This is not possible because this is descending order....
1,5,4,3,2
2,1,5,4,3
===================================================Solve Below 3 case==========================================================


Case1:  (nums[mid] > nums[high])

[3,4,5,1,2]
[2,3,4,5,1]

Case2: (nums[mid] < nums[high])

[1,2,3,4,5] 
[5,1,2,3,4]
[4,5,1,2,3]


Case3:
[2,1,2,2,2] Output: 1
[2,2,2,1,2] Output: 1

Tricks
1) Trick1 : In ordinary binarySearch, we compare with nums[mid] and nums[target], here we compare nums[mid] and nums[high]. If 
question is about find maxInSortedRotatedArray, then we compare nums[mid] and nums[low] 
2) Trick2 :  When both sides equal. we don't consider mid... recursion goes from low to high-1

 */
public class FindMinimumInRotatedSortedArrayII {

  public int findMin(int[] nums) {
    return binSearch(nums, 0, nums.length - 1);
  }

  private int binSearch(int[] nums, int low, int high) {
    if (low >= high) return nums[low]; // nums[low]..nums[high] both will work
    int mid = low + (high - low) / 2;
    // Ex1: [3,4,5,1,2] 
    if (nums[mid] > nums[high]) return binSearch(nums, mid + 1, high);
    // Ex: [1,2,3,4,5]
    else if (nums[mid] < nums[high]) return binSearch(nums, low, mid);
    // when both side is equal... we go by decrementing 1index from low to high. This makes the solution linear.
    // Ex1: [2,1,2,2,2] Output: 1.. nums[mid]=1... move high alone   
    // Ex2:[2,2,2,1,2] Output: 1.. nums[mid]=1... move high alone
    else return binSearch(nums, low, high - 1);
  }
}
