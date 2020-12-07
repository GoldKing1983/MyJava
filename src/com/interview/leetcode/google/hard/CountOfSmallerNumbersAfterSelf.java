package com.interview.leetcode.google.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/count-of-smaller-numbers-after-self/
=========================================================================================================================
Input: [5,2,6,1,1]
Output: [3,2,2,0,0]
Explanation:
To the right of 5 there are 3 smaller elements (2,1,1).
To the right of 2 there are 2 smaller element (1,1).
To the right of 6 there are 3 smaller element (1,1).
To the right of 1 there is 0 smaller element.
To the right of 1 there is 0 smaller element.
==============================================Solution Approach===========================================================
1) Add the last element to TreeMap. Update result for that element to 0. Because for last element,
no smaller element exists.
2) For the "second element from last", fetch element less than that from map.
 */
public class CountOfSmallerNumbersAfterSelf {
  public List<Integer> countSmaller(int[] nums) {
    LinkedList<Integer> result = new LinkedList<>();
    if (nums.length == 0) return result;
    result.addFirst(0);
    int n = nums.length;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(nums[n - 1], 1);
    for (int i = n - 2; i >= 0; i--) {
      Map<Integer, Integer> m = map.headMap(nums[i], false);
      int counts = 0;
      for (Integer count : m.values()) {
        counts += count;
      }
      result.addFirst(counts);
      if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
      else map.put(nums[i], 1);
    }
    return result;
  }
}
