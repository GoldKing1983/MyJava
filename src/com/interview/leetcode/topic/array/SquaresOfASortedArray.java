package com.interview.leetcode.topic.array;

/*
https://leetcode.com/problems/squares-of-a-sorted-array/

Given an array of integers A sorted in non-decreasing order, return an array of the
squares of each number, also in sorted non-decreasing order.

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
=====================Initial Thinking=====================
1) Find the minimal in array. From there go left or right based on which ever is bigger.
The approach is like filling "low to high" from index0.
2) Since Array is sorted, I can see maximum in 0th or n-1th index. So instead of filling from "low to high".
Fill "high to low", that is the simple key to solution.
========================================Solution Approach===============================================
1) Keep 2 pointers head and tail.
2) Multiply data at header and data at tail.
3) Whichever is bigger save in result.
4) If head data is bigger increase head. If tail data is bigger decrease tail.
======================================Data Flow Analysis=========================================================
head is at index: 0 and tail is at index: 4
===head value is: -4 and tail value is  : 10
headSquare<tailSquare. Saving 100 at index 4
======================
head is at index: 0 and tail is at index: 3
===head value is: -4 and tail value is  : 3
headSquare>tailSquare. Saving 16 at index 3
======================
head is at index: 1 and tail is at index: 3
===head value is: -1 and tail value is  : 3
headSquare<tailSquare. Saving 9 at index 2
======================
head is at index: 1 and tail is at index: 2
===head value is: -1 and tail value is  : 0
headSquare>tailSquare. Saving 1 at index 1
======================
head is at index: 2 and tail is at index: 2
===head value is: 0 and tail value is  : 0
headSquare<tailSquare. Saving 0 at index 0

==================================================================================================================
 */
public class SquaresOfASortedArray {
  public int[] sortedSquares(int[] A) {
    int head = 0;
    int tail = A.length - 1;
    int[] result = new int[A.length];
    int resultIndex = tail;
    while (head <= tail) {
      int headSquare = A[head] * A[head];
      int tailSquare = A[tail] * A[tail];
      if (headSquare > tailSquare) {
        result[resultIndex--] = headSquare;
        head++;
      } else {
        result[resultIndex--] = tailSquare;
        tail--;
      }
    }
    return result;
  }
}
