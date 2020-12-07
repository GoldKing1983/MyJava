package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/contains-duplicate-ii/

Problem Statement: Given two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between indices i and indices j is at most k.
Below is the explanation for the given example

Input: nums = [1,2,3,1], k = 3
Output: true

Here element at indices 0 is nums[0]=1 and element at indices 3 is nums[3]=1 which are equal.
Since nums[0] and nums[3] are distinct indices with nums[0]==nums[3]. Also difference between indices 3 and 0 is 3

--> nums[0] == nums[3]
--> (3-0) <= 3 (here k=3 and condition is that difference between indices must not be greater than 3)
--> Hence output is true

==================================================Solution Approach========================================================
1) Simple sliding window.
2) window size cannot go beyond k. If it goes move left.
3) If right goes end, then move left.
Time Complexity: O(n*k)
Ex: [1,2,3,4,5,6] K=6
==== How loop comparism runs ========
left:0 right:1
left:0 right:2
left:0 right:3
left:0 right:4
left:0 right:5
left:1 right:2
left:1 right:3
left:1 right:4
left:1 right:5
left:2 right:3
left:2 right:4
left:2 right:5
left:3 right:4
left:3 right:5
left:4 right:5
===========================================================================================================================
 */
public class ContainsDuplicateIISlidingWindow {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    int left = 0;
    int right = left + 1;
    while (left < nums.length - 1) {
      if (nums[left] == nums[right]) {
        if (right - left <= k) return true;
      }
      right++;
      if (right - left > k || right == nums.length) {
        left++;
        right = left + 1;
      }
    }
    return false;
  }
}
