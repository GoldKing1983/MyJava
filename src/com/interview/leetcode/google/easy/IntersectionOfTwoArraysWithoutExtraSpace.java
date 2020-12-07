package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/intersection-of-two-arrays/


 */
public class IntersectionOfTwoArraysWithoutExtraSpace {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> listResult = new ArrayList<>();
    int n1 = nums1.length, n2 = nums2.length;
    for (int i = 0, j = 0; i < n1 && j < n2; ) {

      while (i + 1 < n1 && nums1[i] == nums1[i + 1]) i++;
      while (j + 1 < n2 && nums2[j] == nums2[j + 1]) j++;

      if (nums1[i] == nums2[j]) {
        listResult.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] > nums2[j]) {
        j++;
      } else {
        i++;
      }
    }
    int i = 0;
    int[] result = new int[listResult.size()];
    for (int num : listResult) {
      result[i++] = num;
    }
    return result;
  }
}
