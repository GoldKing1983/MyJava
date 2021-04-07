package com.interview.leetcode.google.hard;

/*
https://leetcode.com/problems/sliding-window-maximum/description/

O(n*w)
1) Iterate each window and find the max. 
=== Solution Approach =====
1) Iterate each element and update max. 
2) Whenever the window size reached. Update the result with max.
3) Reset left. do step1 and step2 till end.  

 */
public class SlidingWindowMaximum_BruteForce {

  public int[] maxSlidingWindow(int[] array, int windowSize) {
    int[] result = new int[array.length - windowSize + 1];
    int max = Integer.MIN_VALUE;
    int currentWindowSize = 0;
    int resultIndex = 0;

    //traverse the array while shifting the window forward
    for (int left = 0; left < array.length; left++) {
      //find maximum in the current window
      max = Math.max(array[left], max);
      currentWindowSize++;

      if (currentWindowSize == windowSize) {
        result[resultIndex] = max; // Gather max in the result

        max = Integer.MIN_VALUE; // reset max
        left = resultIndex; // reset left
        currentWindowSize = 0; // reset currentWindowSize
        resultIndex++; // increment resultIndex
      }
    }
    return result;

  }

}
