package com.interview.leetcode.google.hard;

/*

https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
Same problem as MinimumSizeSubarraySumSlidingWindow with negative values.
We cannot apply the same code MinimumSizeSubarraySumSlidingWindow because of negative numbers.
Ex: [3, -2, 5] k=4. Answer =1
For above input previous code will return 3. Because, it founds k>=4 at index2. Then Shrink will happen.
It removes element at index0 and finds that it is currSum 3<4. So Shrink stops. Answer is 3... which is wrong.


Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.


Input: A = [1], K = 1
Output: 1

Input: A = [1,2], K = 4
Output: -1

Input: A = [2,-1,2], K = 3
Output: 3

Input: A = [2,-1,2,10], K = 5
Output: 1


 */
public class ShortestSubarrayWithSumAtLeastK {}
