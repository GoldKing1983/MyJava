package com.interview.leetcode.google.hard;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/find-k-th-smallest-pair-distance/
=============================Requirement=============================
Given an integer array, return the k-th smallest distance among all the pairs.
The distance of a pair (A, B) is defined as the absolute difference between A and B.

Input:
nums = [1,3,1], k = 1
Output: 0

Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

=======================================================================================
1) There are n*(n-1)/2 possible combinations of distances are present.

Ex: 4 elements in array [1,2,3,4]...(4*(4-1)/2) = 4*3/2 = 6 combinations.
Then we need to calculate distance between [1,2][1,3][1,4]
										   [2,3][2,4]
										   [3,4]
See image "FindKthSmallestPairDistance.png"

 */
public class FindKthSmallestPairDistanceBruteForce {
  public int smallestDistancePair(int[] nums, int k) {
    Map<Integer, Integer> map = new TreeMap<>();
    // Ex: [1,2].... Only 1 distance is possible
    for (int i = 0; i < nums.length - 1; i++) {
      int previous = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int current = nums[j];
        int distance = Math.abs(current - previous);
        map.put(distance, map.getOrDefault(distance, 0) + 1);
      }
    }
    // System.out.println(map);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int count = entry.getValue();
      while (count-- > 0) {
        k--;
        if (k == 0) return key;
      }
    }
    return -1;
  }
}
