package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/

Input: [1,1,1,2,2,3,3,3,3]   k=2 Output: [3,1]

=====================================================Solution Approach=====================================================
Step1: Count the number of occurrences of number in map.
Step2: With the frequency as index of bucket and value as List<number>.
Because there can be more than one number can exists for a frequency.
Step3: Collect result from biggest count
===========================================================================================================================
Step1 is easy.
Step2 of the problem is "map sort by value", to pick the topK, which is done in various ways.

 *
 */
public class TopKFrequentElementsCountSort {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> frequencyMap = new HashMap<>();

    for (int num : nums) frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

    TreeMap<Integer, List<Integer>> mapSortByValue = new TreeMap<>(Collections.reverseOrder());
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      int key = entry.getKey(), value = entry.getValue();
      mapSortByValue.computeIfAbsent(value, dummy -> new ArrayList<>()).add(key);
    }

    int[] result = new int[k];
    int i = 0;
    for (Map.Entry<Integer, List<Integer>> entry : mapSortByValue.entrySet()) {
      for (Integer value : entry.getValue()) result[i++] = value;
      if (i == k) return result;
    }
    return result;
  }
}
