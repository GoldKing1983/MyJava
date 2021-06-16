package com.interview.leetcode.google.hard;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/sliding-window-maximum/description/

 
        1) Maintain a maxHeap of k elements with their indexes.
        2) Eagerly push k elements to pQ to form the initial sliding window. 
        3) Initial result will be floating on top of pQ. Cache the result.
        4) Start the sliding window. slidingWindowStart=0. slidingWindowEnd=k
        5) Process kth element. 
        6) Push the currentNumber and index to pQ.
        7) Move the sliding the window. slidingWindowStart++. slidingWindowEnd++.
        8) If the pQ top element is less than slidingWindowStart, then remove all. Because they doesn't belong to 
           sliding window. This should happen for happen for more than 1 element. So loop it.
        9) result for the window will be floating on top of pQ. Cache the result.    
        10) Step5 continues till all elements are processed.
        11) Finally return the result.
        12) Time Complexity: O(n(log n)). Ex: 5,4,3,2,1.. k=3.. all the elements will be in pQ. Best Case O(n(log k))
        13) Space Complexity: O(n). Ex: 5,4,3,2,1.. k=3.. all the elements will be in pQ
        

 */
public class SlidingWindowMaximumPriorityQueue {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    
    // index0 is value and index1 is indexOfSpace
    PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b)->b[0]-a[0]); // maxHeap
    for(int i=0; i<k; i++) { // Eagerly push k elements to pQ to form the initial sliding window
        pQ.offer(new int[] {nums[i], i});
    }
    
    int[] result = new int[n - k + 1];
    result[0] = pQ.peek()[0];// Ex: [1,2,3] k=3 result=1
    
    int slidingWindowStart = 0, slidingWindowEnd = k;
    while(slidingWindowEnd < n) { // Ex: [1,2,3,4] k=3 result=1 slidingWindowEnd=3
        
        int currentNumber = nums[slidingWindowEnd];
        pQ.offer(new int[] {currentNumber, slidingWindowEnd}); // Add 4 to pQ.. pQ=[1(0),2(1),3(2),4(3)]

        slidingWindowStart++; // 1
        slidingWindowEnd++; // 4

        while(!pQ.isEmpty() && pQ.peek()[1] < slidingWindowStart) {
            pQ.poll(); // remove 1 which is at head
        }
        
        result[slidingWindowStart] = pQ.peek()[0];
    }
    return result;
    
  }
}
