package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Must see.... Excellent video....https://www.youtube.com/watch?v=LDFZm4iB7tA
Didn't solved 100% percent

Given an array of integers nums and an integer limit, return the size of the longest non-empty
subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

Input: nums = [8,2,4,7], limit = 4
Output: 2
[2,4] or [4,7] both lies within the limit of 4 and their maximum size is 2.

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4
Explanation: The subarray [2,4,7,2] is the longest sub-array result.
If I Pick "any 2 number" from subarray [2,4,7,2], their absolute difference lies with in the limit of 5.

Input: nums = [4,2,2,2,4,4,4, 2,2], limit = 0
Output: 3
If I Pick "any 2 number" from either subarray [2,2,2] or [4,4,4] then absolute difference is 0.

===================================Solution Approach - Sliding Window=========================================================
1) maxDeque -> keeps max element in front or keeps element in descending order
2) minDeque -> keeps min element in front or keeps element in ascending order
Simply, At any point in time, if we do minDeque.peek()/poll(), minDeque should return the min.
							  if we do maxDeque.peek()/poll(), maxDeque should return the max.

3) When processing currentNumber.
3a) In the maxDeque remove all the elements which are smaller than the currentNumber.
Ex1: maxDeque = [10]
currentNumber = 15
remove 10 and add 15.

Ex2: maxDeque = [15]
currentNumber = 10
add 10 to the queue.

3b) In the minDeque remove all the elements which are greater than the currentNumber.
Ex1: maxDeque = [15]
currentNumber = 10
remove 15 and add 10.

Ex2: maxDeque = [10]
currentNumber = 15
add 15 to the queue.


 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
  public int longestSubarray(int[] nums, int limit) {
    Deque<Integer> maxDeque = new ArrayDeque<>();
    Deque<Integer> minDeque = new ArrayDeque<>();
    int left = 0, right = 0;
    while (right < nums.length) {
      int currentNumber = nums[right];
      while (!maxDeque.isEmpty() && currentNumber > maxDeque.peekLast()) maxDeque.pollLast();
      while (!minDeque.isEmpty() && currentNumber < minDeque.peekLast()) minDeque.pollLast();
      maxDeque.add(currentNumber);
      minDeque.add(currentNumber);
      int maxElement = maxDeque.peek();
      int minElement = minDeque.peek();
      // Shrink Window. Because difference is greater than limit
      if (maxElement - minElement > limit) {
        if (maxElement == nums[left]) maxDeque.poll();
        if (minElement == nums[left]) minDeque.poll();
        left++;
      }
      right++;
    }
    return right - left;
  }
}
