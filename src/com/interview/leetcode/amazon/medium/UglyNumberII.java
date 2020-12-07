package com.interview.leetcode.amazon.medium;

import java.util.PriorityQueue;

/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. Returning the top ugly number
===========================================Solution Approach===========================================
1) Instead of verifying each number isUgly or not.
2) Starting 1. generate Ugly Number itself, from 2,3,5.
3) Poll till n values.
Note: Skip Duplicate uglyNumbers ex: 6 and 10
===========================================Data Flow Analysis===========================================
Input: n = 10 Output: 12

Current Ugly Number is : 1
Newly generated Ugly Number from  : 1 are : 2, 3, 5
Updated Priority Content is : [2, 3, 5]

Current Ugly Number is : 2
Newly generated Ugly Number from  : 2 are : 4, 6, 10
Updated Priority Content is : [3, 4, 5, 6, 10]

Current Ugly Number is : 3
Newly generated Ugly Number from  : 3 are : 6, 9, 15
Updated Priority Content is : [4, 5, 6, 6, 9, 10, 15]

Current Ugly Number is : 4
Newly generated Ugly Number from  : 4 are : 8, 12, 20
Updated Priority Content is : [5, 6, 6, 8, 9, 10, 12, 15, 20]

Current Ugly Number is : 5
Newly generated Ugly Number from  : 5 are : 10, 15, 25
Updated Priority Content is : [6, 6, 8, 9, 10, 10, 12, 15, 15, 20, 25]

Skipping Duplicate Ugly Number : 6
Current Ugly Number is : 6
Newly generated Ugly Number from  : 6 are : 12, 18, 30
Updated Priority Content is : [8, 9, 10, 10, 12, 12, 15, 15, 18, 20, 25, 30]

Current Ugly Number is : 8
Newly generated Ugly Number from  : 8 are : 16, 24, 40
Updated Priority Content is : [9, 10, 10, 12, 12, 15, 15, 16, 18, 20, 24, 25, 30, 40]

Current Ugly Number is : 9
Newly generated Ugly Number from  : 9 are : 18, 27, 45
Updated Priority Content is : [10, 10, 12, 12, 15, 15, 16, 18, 18, 20, 24, 25, 27, 30, 40, 45]

Skipping Duplicate Ugly Number : 10
Current Ugly Number is : 10
Newly generated Ugly Number from  : 10 are : 20, 30, 50
Updated Priority Content is : [12, 12, 15, 15, 16, 18, 18, 20, 20, 24, 25, 27, 30, 30, 40, 45, 50]


 */
public class UglyNumberII {
  public int nthUglyNumber(int n) {
    PriorityQueue<Long> q = new PriorityQueue<>();
    q.offer(1l); // Push the first Ugly Number

    while (n > 1) { // if n=1. loop will not execute.
      long currentUgly = q.poll();
      if (!q.isEmpty() && q.peek() == currentUgly) continue;

      // Generate next set of ugly numbers from currentyUglyNumber.
      q.offer(currentUgly * 2);
      q.offer(currentUgly * 3);
      q.offer(currentUgly * 5);

      n--;
    }
    return q.poll().intValue();
  }
}
