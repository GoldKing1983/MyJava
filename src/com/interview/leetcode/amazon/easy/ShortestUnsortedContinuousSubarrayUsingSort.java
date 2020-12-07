package com.interview.leetcode.amazon.easy;

import java.util.Arrays;

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
================================================Solution Approach==========================================================
1) Sort the number.
Ex: Input       : [2, 6, 4, 8, 10, 9, 15]
	SortedInput : [2, 4, 6, 8, 9, 10, 15]

2) Now from leftToRight. Compare sortedInput and unSortedInput. If there is a difference. Mark it as left.
Take that first unsorted index.
 	Ex: For above input. left= 1

3) 	   From rightToLeft. Compare sortedInput and unSortedInput. If there is a difference. Mark it as right.
	Ex: For above input. right= 5

4) Ans = right-left+1 = 5-1+1 = 5
*/
public class ShortestUnsortedContinuousSubarrayUsingSort {
  public int findUnsortedSubarray(int[] input) {
    int n = input.length;
    int[] sortedInput = input.clone();
    Arrays.sort(sortedInput);

    int left = 0;
    while (left < n && input[left] == sortedInput[left]) left++;
    // Ex:[1,2,3,4]. Input is sorted. So left will go out of bound of input. So Return 0.
    if (left == n) return 0;

    int right = n - 1;
    while (right >= 0 && input[right] == sortedInput[right]) right--;

    return right - left + 1;
  }
}
