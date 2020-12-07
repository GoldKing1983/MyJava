package com.interview.leetcode.amazon.easy;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/

Same as KthLargestElementInAStreamSimple avoiding second loop by comparing not adding to the pQ.


 */
public class KthLargestElementInAStream {

  Queue<Integer> pQ = new PriorityQueue<>();
  int k = 0;

  public KthLargestElementInAStream(int k, int[] nums) {
    this.k = k;
    for (int num : nums) {
      if (pQ.size() == k && num < pQ.peek()) continue; // Avoiding unnecessary adding of new data.
      pQ.offer(num);
      if (pQ.size() > k) pQ.poll();
    }
  }

  public int add(int val) {
    pQ.offer(val);
    // "If" condition is needed for negative scenarios. Ex: nums is empty and k = 10.
    if (pQ.size() > k) pQ.poll();
    return pQ.peek();
  }
}
