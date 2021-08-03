package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/

Input: [1,1,1,2,2,3,3,3,3]   k=2 Output: [3,1]

=============================================Solution Approach=============================================
Step1: Count the number of occurrences of number.
Step2: For Each of number, add it to pQ, sorted by count. Keep only top K.
Step3: Collect result from pQ.
=============================================Solution Approach Alternate===================================
Step2 can be QuickSelect which beats 100% beats.
 *
 */
public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    // [1->3][2->2][3->1]
    for (Integer n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

    //return getTopKImplementedUsingTreeMap(map,k);
    return getTopKImplementedUsingPriorityQueue(map, k);
  }

  // PriorityQueue n(log(k))
  private int[] getTopKImplementedUsingPriorityQueue(Map<Integer, Integer> map, int k) {
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]); // minHeap
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pQ.offer(new int[] {entry.getValue(), entry.getKey()});
      if (pQ.size() > k) pQ.poll();
    }

    int[] result = new int[k];
    int resultIndex = 0;
    while (!pQ.isEmpty()) {
      result[resultIndex++] = pQ.poll()[1];
    }
    return result;

  }

  // TreeMap n(log(n))
  private int[] getTopKImplementedUsingTreeMap(Map<Integer, Integer> map, int k) {
    Map<Integer, List<Integer>> tMap = new TreeMap<>(Collections.reverseOrder());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      tMap.computeIfAbsent(entry.getValue(), v -> new ArrayList<>()).add(entry.getKey());
    }

    int[] result = new int[k];
    int resultIndex = 0;
    for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
      for (int v : entry.getValue()) {
        result[resultIndex++] = v;
        if (resultIndex == k) return result;
      }
    }
    return result;
  }
}
