package com.interview.leetcode.google.medium;

import java.util.TreeSet;

/*
 * https://leetcode.com/problems/contains-duplicate-iii/

Requirement: Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Case1: left and right index or window should be less than or equal to k.
Case2: Difference value between left and right should be less than or equal to t.
==================================================Solution Approach==================================================
1) Sliding Window + Bucket Sort
2) Keep only k entries in Set.
3) Using "TreeSet" find higherValue and lowerValue. If the difference is <=t return true.
=========================Tricky Input=========================
[10,100,11,9]
1
2
Output: True

10
Higher null
Lower null
right:0 left:0
Set {10=0}

100
Higher null
Lower 10
right:1 left:0
Set {100=1}

11
Higher 100
Lower null
right:2 left:1
Set {11=2}

9
Higher 11

===========================================================================


 */
public class ContainsDuplicateIII {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k == 0) return false;
    TreeSet<Long> set = new TreeSet<>();
    int left = 0;
    int right = 0;
    for (int numInteger : nums) {
      Long num = (long) numInteger;

      Long higher = set.ceiling(num);
      if (higher != null && higher - num <= t) return true;

      Long lower = set.floor(num);
      if (lower != null && num - lower <= t) return true;

      if (right - left >= k) set.remove((long) nums[left++]);

      set.add(num);
      right++;
    }
    return false;
  }
}
