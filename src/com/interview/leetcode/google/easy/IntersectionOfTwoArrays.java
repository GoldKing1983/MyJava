package com.interview.leetcode.google.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/intersection-of-two-arrays/

Given two arrays, write a function to compute their intersection.
Requirement Understanding:
1) Whatever is common in both the array add it result.
2) If there is duplicate ignore it.

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

==================================================Solution Approach===========================================================
Solution1) Put any-one "array" in set. Search for the other.
Solution2) Sort any-one, do binary-search.
Solution3) Sort both. Use 2 Pointer approach to navigate.
 */
public class IntersectionOfTwoArrays {
  // Solution1
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> seen = new HashSet<>();
    Set<Integer> seen2 = new HashSet<>();

    for (int num : nums1) seen.add(num);

    int[] output = new int[nums1.length];
    int inx = 0;

    for (int num : nums2) {
      if (seen.contains(num)) {
        if (!seen2.contains(num)) {
          output[inx++] = num;
          seen2.add(num);
        }
      }
    }

    return Arrays.copyOfRange(output, 0, inx);
  }
}
