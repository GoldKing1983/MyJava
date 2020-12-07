package com.interview.leetcode.amazon.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/contains-duplicate/

Requirement: Given an array of integers, find if the array contains any duplicates.

Input: [1,2,3,1]
Output: true

Input: [1,2,3,4]
Output: false

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true



 */
public class ContainsDuplicate {
  // Time Complexity : O(n(log n))
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  // Time Complexity : O(n). Space Complexity: O(n)
  public boolean containsDuplicateUsingSet(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x : nums) {
      if (set.contains(x)) return true;
      set.add(x);
    }
    return false;
  }
}
