package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-k-closest-elements/description/


 */
public class FindKClosestElementsBest {

  public List<Integer> findClosestElements(int[] arr, int k, int target) {
    return generate(arr, k, target, 0, arr.length - k);
  }

  public List<Integer> generate(int[] nums, int k, int target, int left, int right) {
    if (left == right) {
      List<Integer> list = new ArrayList<>();
      for (int i = left; i < left + k; i++) list.add(nums[i]);
      return list;
    }
    int mid = left + (right - left) / 2;
    // Ex: [1,3,5] target=2, k=1
    if (target - nums[mid] > nums[mid + k] - target) {
      return generate(nums, k, target, mid + 1, right);
    }
    return generate(nums, k, target, left, mid);
  }
}
