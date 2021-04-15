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
1) Cache the index[0] as result. This is needed. Because, if all element is sorted. Then logic goes all the way right.
Ex: [1,2,3,4,5] and terminates when low==high==index4.  

2) Only one condition. If nums[mid] < firstNumber. nums[mid] could be a possible result. 
Cache it and Go towards Left to find still minimum.
Ex: [8,0,1,2,3,4,5,6,7].low=0, high=8. mid=index4 i.e.3.
3 < 8
Cache 3 in result. Go Left.

2) This logic is similar to InorderSuccessorInBSTBest.
============================================Possible Cases==================================================================

Since the array is sorted and rotated. At any point, if I split the array, there can be "3 cases".
					Case1:	   Ex: [3,4,5,1,2]. Initially mid stays at index2. Left  side sorted. Right side not sorted.
					Case2:	   Ex: [4,5,1,2,3]. Initially mid stays at index2. Right side sorted. Left side not sorted.
					Case3:	   Ex: [1,2,3,4,5]. Initially mid stays at index2. Both side sorted.
		==========Below case are not possible= or possible in descending sorted rotated array=========try rotate and see
					CaseWrong1:	   Ex: [5,4,3,2,1].
					CaseWrong2:    Ex: [2,1,5,4,3]


 */
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    int firstNumber = nums[0];
    // Save the result for the case [1,2,3,4,5].. Because in this on seeing mid, we have to go left. 
    // But logic goes right. Code never updates the cacheResult. We send the initial filled result.
    int result = firstNumber;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      // Ex: [50,10,20,30,40].low=0, high=4. mid=index2 i.e.20. 20<50. Cache 20 and go left
      if (nums[mid] < firstNumber) {
        result = nums[mid]; // mid could be possible result. So save it.
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return result;
  }
}
