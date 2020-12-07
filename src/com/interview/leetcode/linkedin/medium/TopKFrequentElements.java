package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
    for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

    // 0thIndex holds Number... 1stIndex holds Count
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pQ.offer(new int[] {entry.getKey(), entry.getValue()});
      if (pQ.size() > k) pQ.poll(); // optimization
    }

    int size = pQ.size();
    int[] result = new int[size];
    while (size-- > 0) result[size] = pQ.poll()[0];

    return result;
  }
}
