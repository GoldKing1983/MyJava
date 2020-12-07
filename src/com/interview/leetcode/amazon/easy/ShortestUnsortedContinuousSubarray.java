package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

===============================================Requirement===============================================
Given an integer array, you need to
	1) find "one shortest subarray" that
	2) "if you only sort this subarray" in ascending order,
	3) then the whole array will be sorted in ascending order, too.


Input: [2, 6, 4, 8, 10, 9, 15] Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order, than will make [4,6,8,9,10].
Now if I attach this to main array between 2 and 15 [2,4,6,8,9,10,15] then whole array is sorted.
So the result count is 5.

Input = [1,3,2,2,2] Output = 4
I need to sort [3,2,2,2] and attach it with 1. So the result count is 4.

Input = [1,2,3,3,3] Output = 0
already in sorted order. So the result count is 0.
================================================Solution Approach==Time Complexity O(n)==========================================
Its lot of code. But logic is simple. Refer video https://www.youtube.com/watch?v=p-O7FExDH1M
Ex: [2,6,4,3,11, 10,9,15]
1) From leftToRight, find the minimum of unsorted element.
   Ex: For above input. Start from 1st index. Compare current and previous element.
   2,6 --> sorted.
   6,4 --> not sorted. Current min is 4.
   4,3 --> not sorted. Current min is 3.
   min stays same for rest of traversal.

2) From rightToLeft, find the maximum of unsorted element.
   Ex: For above input. Start from 1st index. Compare current and next element.
   9,15 --> sorted.
   10,9 --> not sorted. Current max is 10.
   11,10 --> not sorted. Current max is 11.
   max stays same for rest of traversal.

3) Now this min and max needs to be attached at right index. We don't worry about rest of element. like quick select.
4) For min to attach go from leftToRight.
   3 < 2.  No. Move Next.
   3 < 6. Yes. We can Attach 3 at index 1.
5) For max to attach go from rightToLeft.
   11 > 15. No... move next
   11 > 9. Yes we can Attach 11 at index 6.

6) Ans :right-left+1 = 6-1+1 = 6.


*/
public class ShortestUnsortedContinuousSubarray {
  public int findUnsortedSubarray(int[] nums) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    boolean sorted = true; // Sorted Logic added for performance booster.
    int firstUnSortedIndex = 1;
    while (firstUnSortedIndex < nums.length) {
      if (nums[firstUnSortedIndex] < nums[firstUnSortedIndex - 1]) {
        sorted = false;
        break;
      }
      firstUnSortedIndex++;
    }

    if (sorted) return 0;
    while (firstUnSortedIndex < nums.length) {
      min = Math.min(min, nums[firstUnSortedIndex]);
      firstUnSortedIndex++;
    }

    firstUnSortedIndex = nums.length - 2;
    while (firstUnSortedIndex >= 0) {
      if (nums[firstUnSortedIndex] > nums[firstUnSortedIndex + 1]) {
        break;
      }
      firstUnSortedIndex--;
    }

    while (firstUnSortedIndex >= 0) {
      max = Math.max(max, nums[firstUnSortedIndex]);
      firstUnSortedIndex--;
    }

    int left, right;
    for (left = 0; left < nums.length; left++) {
      if (min < nums[left]) break;
    }
    for (right = nums.length - 1; right >= 0; right--) {
      if (max > nums[right]) break;
    }
    return right - left + 1;
  }
}
