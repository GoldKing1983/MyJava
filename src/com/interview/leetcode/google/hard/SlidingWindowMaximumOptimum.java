package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/sliding-window-maximum/description/
https://www.educative.io/collection/page/5642554087309312/5679846214598656/210002
================================================Requirement================================================
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
=======================================Solution Approach===================================================================
This problem is an extension of problem "NextGreaterElementIRightApproach". So understand "NextGreaterElementIRightApproach"
Below solution is possible, because of doubly linked list where we can insert/delete at both ends


 */
public class SlidingWindowMaximumOptimum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }
    Deque<Integer> deque = new ArrayDeque<>(k);
    int[] res = new int[nums.length + 1 - k];
    // Before a full window, simply update element to queue
    for (int i = 0; i < k - 1; i++) {
      updateQueue(deque, nums[i]);
    }
    // Once the desired window is achieved, get result from head.
    for (int i = 0; i < res.length; i++) {
      updateQueue(deque, nums[i + k - 1]);
      res[i] = deque.peek(); // peek data as queue
      // remove the element at head if its index no longer falls in current window
      if (nums[i] == deque.peek()) {
        deque.poll();// poll data as queue
      }
    }
    return res;
  }

  private void updateQueue(Deque<Integer> queue, int currentNumber) {
    while (!queue.isEmpty() && currentNumber > queue.peekLast()) {
      queue.removeLast();
    }
    queue.offer(currentNumber);
  }
}
