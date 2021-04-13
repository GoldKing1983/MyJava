package com.interview.leetcode.amazon.easy;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream.
For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

---Example:---
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
================================================Solution Approach================================================================
1) Keep only k element in the pQ. Since pQ is minHeap. data will be assembled in ascendingOrder(small to large).
So topElement will be the KthLargest Element.
2) During add, add the currentElement. Remove the topOne. return the topOne.
Ex1: k=3 pQ=[10,20,30]..
Adding 5 will change pQ to [5,10,20,30] remove 5. return 10.

Ex2: k=3 pQ=[10,20,30]..
Adding 25 will change pQ to [10,20,25,30] remove 10. return 20.

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
