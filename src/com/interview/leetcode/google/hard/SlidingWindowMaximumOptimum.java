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


There are 2 cases the window in pQ can shrink
case1: when currentNumber > deque.peekLast().. this shrink can happen any-time.. i.e before or after full window
       Ex: [1,2,3,4,5,6] k=5... at index4 processing deque=[5]... window shrinked before fully forming. 
       
       This logic is also similar to NextGreaterElementIRightApproach.
         

case2: when window moves. left side data needs to be removed and right side will be added.
                          So i need to remove leftSide data.
                          But I don't know which one to pick or when to pick. 
                          So I will see if dequeHead has windowStartData then remove from leftSide.
       Ex: [6,5,4,3,2,1] k=5... at index4 processing deque=[6,5,4,3,2] result=[6].
                          So if nums[windowBegninning]==dequeHead then remove dequeHead.  
                          it cannot be "result[windowBegninning]==dequeHead". because sameResult continues for more than 1Window. 

1) Below solution is possible, because of doubly linked list where we can insert/delete at both ends
2) Because in case1 we do peekLast and removeLast.
           in case2 we do peek(peekFirst) and poll(removeFirst)


 */
public class SlidingWindowMaximumOptimum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> deque = new ArrayDeque<>(k);
    int[] res = new int[n + 1 - k];

    int windowBeginning = 0;
    for (int i = 0; i < n; i++) {
      int currentNumber = nums[i];
      // Case 1 Shrink. Similar to NextGreaterElementIRightApproach
      while (!deque.isEmpty() && currentNumber > deque.peekLast()) {
        deque.removeLast();
      }
      deque.offer(currentNumber);

      /*
        Ex: 1,3,-1 k=3.. continue works 2 times... deque=[3]
        Till the initial window not formed, shrink by case1 only
       */
      if (i < k - 1) continue;

      res[windowBeginning] = deque.peek(); // peek data as queue

      // Case 2 Shrink
      if (nums[windowBeginning] == deque.peek()) {
        deque.poll();// remove firstElement from queue
      }

      windowBeginning++;
    }
    return res;
  }
}
