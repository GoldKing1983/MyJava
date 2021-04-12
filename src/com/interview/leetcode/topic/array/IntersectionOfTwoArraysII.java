package com.interview.leetcode.topic.array;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

=======================================================Solution Approach=========================================================
1) Since intersection also needs to consider duplicate. Put "nums1" to  map and count the number of occurrence.
2) For each of "nums2"(currentNumber). verify it exists in num1Map.
3) If "currentNumber" exists in "num1Map" and add currentNumber to result.
4) Else move on to next element.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> nums1Map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums1.length; ++i) {
      nums1Map.put(nums1[i], nums1Map.getOrDefault(nums1[i], 0) + 1);
    }
    // System.out.println(nums1Set);
    for (int i = 0; i < nums2.length; ++i) {
      int val = nums2[i];
      if (nums1Map.containsKey(val)) {
        int count = nums1Map.get(val);
        if (count > 0) {
          res.add(val);
          --count;
          nums1Map.put(val, count);
        }
      }
    }
    // System.out.println(res);
    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); ++i) {
      result[i] = res.get(i);
    }
    return result;
  }

  public int[] intersectUsingBucket(int[] nums1, int[] nums2) {
    int[] bucket = new int[1001]; // 0 to 1000
    for (int num1 : nums1) bucket[num1]++;
    
    int[] result = new int[Math.max(nums1.length, nums2.length)];
    int i = 0;
    
    for (int num2 : nums2) {
      if (bucket[num2] > 0) {
        result[i++] = num2;
        bucket[num2]--;
      }
    }
    
    return Arrays.copyOf(result, i);
  }
}
