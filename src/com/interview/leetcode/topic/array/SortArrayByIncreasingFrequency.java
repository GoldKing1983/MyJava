package com.interview.leetcode.topic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
===========================================================Requirement===========================================================
https://leetcode.com/problems/sort-array-by-increasing-frequency/
============================================================Example1=============================================================
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
============================================================Example1=============================================================
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
========================================================Solution Approach========================================================
1) Add count of each number and number to map.
2) Map cannot be sorted by value. So add map content to array.
3) Sort the array by requirement.
4) Form result back and return. 
 */
public class SortArrayByIncreasingFrequency {

  public int[] frequencySort(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
    // 0thIndexIsValue, 1stIndexIsCount
    int[][] sorted = new int[map.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      sorted[i][0] = entry.getKey();
      sorted[i++][1] = entry.getValue();
    }
    Arrays.sort(sorted, (a, b) -> {
      // If count is same. Then return lowest value first. Ex: 2,2,1,1 result:1,1,2,2
      if (a[1] == b[1]) return b[0] - a[0];
      return a[1] - b[1]; // smallest count comes first. i.e ascending
    });
    int[] result = new int[nums.length];
    int resultIndex = 0;
    for (int[] s : sorted) {
      int value = s[0];
      int count = s[1];
      while (count-- > 0) result[resultIndex++] = value;
    }
    return result;

  }
}
