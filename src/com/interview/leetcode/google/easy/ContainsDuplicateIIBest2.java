package com.interview.leetcode.google.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/contains-duplicate-ii/

Problem Statement: Given two distinct indices i and j in the array such that nums[i] = nums[j] and the
absolute difference between indices i and indices j is "at most" K i.e less than or equal to K.

Input: nums = [1,2,3,1], k = 3
Output: true

Here element at indices 0 is nums[0]=1 and element at indices 3 is nums[3]=1 which are equal.
Since nums[0] and nums[3] are distinct indices with nums[0]==nums[3]. Also difference between indices 3 and 0 is 3

--> nums[0] == nums[3]
--> (3-0) <= 3 (here k=3 and condition is that difference between indices must not be greater than 3)
--> Hence output is true
==================================================Solution Approach========================================================
1) Sliding Window + Buckets of Data
2) Keep only K(Window) numbers by using left and right.
3) If a number found with in the window, return true.
===========================================================================================================================
 */
public class ContainsDuplicateIIBest2 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (Integer left = 0, right = 0; right < nums.length; right++) {
      Integer rightNumber = nums[right];
      if (set.contains(rightNumber)) return true;
      set.add(rightNumber);
      if (set.size() > k) set.remove(nums[left++]);
    }
    return false;
  }
}
