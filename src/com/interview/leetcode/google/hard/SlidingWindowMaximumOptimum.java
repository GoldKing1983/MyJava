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

Note: In Deque we are keeping only the index. We can get number by referring from nums.

There are 2 cases the window in pQ can shrink
case1: when currentNumber > deque.peekLast().. this shrink can happen any-time.. i.e before or after full window
       Ex: [1,2,3,4,5,6] k=5... at index4 processing deque=[4]... window shrinked before fully forming. 
       
       This logic is also similar to NextGreaterElementIRightApproach.
         

case2: when window moves. left side data needs to be removed and right side will be added. So i need to remove leftSide data.
                          But I don't know which one to pick or when to pick. So I will see if dequeHead >= slidingWindowStart
                          
       Ex: [6,5,4,3,2,1] k=5... at index5 processing number1 deque=[0,1,2,3,4]... slidingWindowStart=0  
                                                                                  dQ.peekFirst()=0. So remove 0 from dQ

        1) Maintain a Deque of k elements with their indexes.
        2) Eagerly push k elements to dQ to form the initial sliding window. 
           Remove all element which are greater than currentElement. Similar to NextGreaterElementIRightApproach
           Ex: [1,2,3,4,5]...k=5.. dQ=[5]
        3) Initial result will be floating on top of dQ. Cache the result.
        4) Start the sliding window. slidingWindowStart=0. slidingWindowEnd=x
        5) Process xth element. 
        6) Remove all element which are out of sliding window. This is done by using index.
        7) Remove all element which are greater than currentElement. Similar to NextGreaterElementIRightApproach
        8) Push the currentElementIndex to dQ.
        9) result for the window will be floating on top of pQ. Cache the result.    
        10) Move the sliding the window. slidingWindowStart++. slidingWindowEnd++.
        11) Step5 continues till all elements are processed.
        12) Finally return the result.
        13) Time Complexity: O(n).
        13) Space Complexity: O(k). Because we always trim element out of window.
        
        
1) Below solution is possible, because of doubly linked list where we can insert/delete at both ends
2) Because in case1 we do peekLast and removeLast.
           in case2 we do peekFirst and removeFirst


 */
public class SlidingWindowMaximumOptimum {

  public int[] maxSlidingWindow(int[] nums, int k) {

    int n = nums.length;
    Deque<Integer> dQ = new ArrayDeque<>();

    // Eagerly push first x elements to dQ. Keep elements in descending order
    for (int i = 0; i < k; i++) {
      int currentNumber = nums[i];
      // Remove all element which are greater than currentElement. Similar to NextGreaterElementIRightApproach
      // Ex: 2,10.. x=2 at second iteration dQ=[10]... i.e 2 will be removed
      while (!dQ.isEmpty() && currentNumber > nums[dQ.peekLast()]) {
        dQ.removeLast();
      }
      dQ.addLast(i);
    }

    int[] result = new int[n - k + 1];
    result[0] = nums[dQ.peek()];
    int slidingWindowStart = 0, slidingWindowEnd = k;

    while (slidingWindowEnd < n) {

      // Remove all element which are out of sliding window
      // Ex: 1,2,3,4...x=3 slidingWindowStart=0..dQ=[0,1,2]... remove 0 at first
      while (!dQ.isEmpty() && slidingWindowStart >= dQ.peekFirst()) {
        dQ.removeFirst();
      }

      int currentNumber = nums[slidingWindowEnd];
      // Remove all element which are greater than currentElement. Similar to NextGreaterElementIRightApproach
      // Ex: 1,3,5,2.. x=3... currentNumber=2 dQ=[1,3,5]... remove 3 and 5... So dQ=[1]
      while (!dQ.isEmpty() && currentNumber > nums[dQ.peekLast()]) {
        dQ.removeLast();
      }

      dQ.offer(slidingWindowEnd);

      slidingWindowStart++;
      slidingWindowEnd++;

      result[slidingWindowStart] = nums[dQ.peek()];// Cache the result from top of dQ
    }
    return result;

  }
}
